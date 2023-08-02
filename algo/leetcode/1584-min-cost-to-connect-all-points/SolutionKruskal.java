import java.util.PriorityQueue;

class SolutionKruskal {

    int[] parent;
    int[] sz;

    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        PriorityQueue<Integer[]> PQ 
            = new PriorityQueue<>((e1, e2) -> e1[2] - e2[2]);
        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    continue;
                }
                Integer d = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]); 
                PQ.add(new Integer[]{i, j, d});
            }
        }

        int edges = 0;
        int cost = 0;
        parent = new int[V];
        sz = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            sz[i] = 1;
        }

        while (!PQ.isEmpty() && edges < V-1) {
            Integer[] e = PQ.poll();
            if (!connected(e[0], e[1])) {
                union(e[0], e[1]);
                cost += e[2];
                edges++;
            }
        }
        return cost;
    }

    private boolean connected(int v1, int v2) {
        return find(v1) == find(v2);
    }

    private int find(int v) {
        while (v != parent[v]) {
            v = parent[v];
        }
        return v;
    }

    private void union(int v1, int v2) {
        int r1 = find(v1);
        int r2 = find(v2);
        if (r1 == r2) {return; }
        if (sz[r1] < sz[r2]) {
            parent[r1] = r2;
            sz[r2] += sz[r1];
        } else {
            parent[r2] = r1;
            sz[r1] += sz[r2];
        }
    }

    public static void main(String[] args) {
        testSolutionKruskal_1();
    }

    public static void testSolutionKruskal_1() {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        SolutionKruskal s = new SolutionKruskal();
        int output = s.minCostConnectPoints(points);
        boolean passed = output == 20;
        System.out.println("testSolutionKruskal_1: " + (passed ? "passed" : "failed"));
    }
}