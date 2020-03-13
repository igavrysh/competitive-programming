import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUnionFind uf;
    private int n;
    private int openedQnt = 0;
    private boolean[] opened;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Grid size must be positive number");
        }
        this.n = n;
        uf = new WeightedQuickUnionUnionFind(n + 2);
        opened = new boolean[n * n];
        for (int i = 0; i < n; i++) {
            uf.union(i, n);
            uf.union(n * (n - 1) + i, n + 1);
            for (int j = 0; j < n; j++) {
                opened[i * n + j] = false;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isValid(row, col)) {
            throw new IllegalArgumentException("Rows and cols must be within size of the grid");
        }

        if (!opened[dim(row, col)]) {
            return;
        }

        opened[dim(row, col)] = true;
        openedQnt += 1;

        if (isValid(row - 1, col) && opened[dim(row - 1, col)]) {
            uf.union(dim(row - 1, col), dim(row, col));
        }
        if (isValid(row + 1, col) && opened[dim(row + 1, col)]) {
            uf.union(dim(row + 1, col), dim(row, col));
        }
        if (isValid(row, col-1) && opened[dim(row, col - 1)]) {
            uf.union(dim(row, col - 1), dim(row, col));
        }
        if (isValid(row, col + 1) && opened[dim(row, col - 1)]) {
            uf.union(dim(row, col + 1), dim(row, col));
        }
    }

    private int dim(int row, int col) {
        return (row - 1) * n + (col - 1);
    }

    private boolean isValid(int row, int col) {
        return dim(row, col) >= 0 && dim(row, col) < n * n + 2;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return opened[dim(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return uf.connected(n * n, dim(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openedQnt;
    }

    // does the system percolate?
    public boolean percolates() {
        return isFull(n, n + 2);
    }

    // test client (optional)
    public static void main(String[] args) {
        System.out.println("Hello world!!!");
    }
}

class QuickUnionUnionFind {
    private int[] id;

    public QuickUnionUnionFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}

class WeightedQuickUnionUnionFind {
    private int[] id;
    private int[] sz;

    public WeightedQuickUnionUnionFind(int N) {
        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
