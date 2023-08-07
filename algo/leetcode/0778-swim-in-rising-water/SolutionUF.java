import java.util.PriorityQueue;

public class SolutionUF {

    int[] parent;
    int[] sz;
    
    public int swimInWater(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int V = rows * cols;
        parent = new int[V];
        sz = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
        
        PriorityQueue<int[]> PQ = new PriorityQueue<>((int[] p1, int[]p2) -> grid[p1[0]][p1[1]] - grid[p2[0]][p2[1]]);
        for (int i = 0; i < rows*cols; i++) {
            PQ.offer(new int[]{i/cols,i%cols});
        }
        int waterLevel = grid[0][0];
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!PQ.isEmpty()) {
            int[] p = PQ.poll();
            if (waterLevel < grid[p[0]][p[1]]) {
                waterLevel = grid[p[0]][p[1]];
            }
            for (int[] dir : dirs) {
                int i = p[0], j = p[1];
                int newI = p[0] + dir[0], newJ = p[1] + dir[1];
                if (newI < 0 || newI >= rows || newJ < 0 || newJ >= cols) {
                    continue;
                }

                if (grid[newI][newJ] <= grid[i][j]) {
                    union(newI*cols + newJ, i*cols + j);
                } else {
                    PQ.offer(new int[]{newI,newJ});
                }
            }

            if (find(0) == find(V-1)) {
                return waterLevel;
            }
        }
        return -1;
    }

    private int find(int p) {
        int root = p;
        while (root != parent[root]) root = parent[root];
        while (p != root) {
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return root;
    }

    private void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i==j) return;

        if (sz[i] < sz[j]) { 
            parent[i] = j;
            sz[j] += sz[i];
        } else {
            parent[j] = i;
            sz[i] += sz[j];
        }
    }

    public static void main(String[] args) {
        testSolutionUF_1();
        testSolutionUF_2();
        testSolutionUF_3();
        testSolutionUF_4();
    }

    public static void testSolutionUF_1() {
        int[][] grid =  {{0,2},{1,3}};
        int expected = 3;
        SolutionUF s = new SolutionUF();
        int actual = s.swimInWater(grid);
        boolean passed = actual == expected;
        System.out.println("testSolutionBS_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionUF_2() {
        int[][] grid = {
            { 0, 1, 2, 3, 4},
            {24,23,22,21, 5},
            {12,13,14,15,16},
            {11,17,18,19,20},
            {10, 9, 8, 7, 6}
        };
        int expected = 16;
        SolutionUF s = new SolutionUF();
        int actual = s.swimInWater(grid);
        boolean passed = actual == expected;
        System.out.println("testSolutionUF_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionUF_3() {
        int[][] grid = {{3,2},{0,1}};
        int expected = 3;
        SolutionUF s = new SolutionUF();
        int actual = s.swimInWater(grid);
        boolean passed = actual == expected;
        System.out.println("testSolutionUF_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionUF_4() {
        int[][] grid = {{0}};
        int expected = 0;
        SolutionUF s = new SolutionUF();
        int actual = s.swimInWater(grid);
        boolean passed = actual == expected;
        System.out.println("testSolutionUF_4: " + (passed ? "passed" : "failed"));
    }
}
