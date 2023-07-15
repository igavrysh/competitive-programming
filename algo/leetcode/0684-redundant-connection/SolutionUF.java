class SolutionUF {
    private int[] id;
    private int[] sz;
    private int count;

    public int[] findRedundantConnection(int[][] edges) {
        int maxV = 0;
        for (int i = 0; i < edges.length; i++) {
            maxV = Math.max(maxV, edges[i][0]);
            maxV = Math.max(maxV, edges[i][1]);
        }

        count = maxV;
        id = new int[maxV];
        sz = new int[maxV];
        for (int i=0; i<id.length; i++) {
            id[i] = i;
            sz[i] = 1;
        }

        int[] result = null;

        for (int i = 0; i < edges.length; i++) {
            if (find(edges[i][0]-1) == find(edges[i][1]-1)) {
                result = edges[i];
            }
            union(edges[i][0]-1, edges[i][1]-1);
        }

        return result;
    }

    private int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    private void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i==j) return;

        if (sz[i] < sz[j]) { 
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
        testSolutionUF_1();
        testSolutionUF_2();
    }

    public static void testSolutionUF_1() {
        int[][] edges = {{1,2},{1,3},{2,3}};
        SolutionUF s = new SolutionUF();
        int[] output = s.findRedundantConnection(edges);
        int[] expOutput = new int[]{2,3};
        boolean passed = output[0] == expOutput[0] && output[1] == expOutput[1];
        System.out.println("testSolutionUF_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionUF_2() {
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        SolutionUF s = new SolutionUF();
        int[] output = s.findRedundantConnection(edges);
        int[] expOutput = new int[]{1,4};
        boolean passed = output[0] == expOutput[0] && output[1] == expOutput[1];
        System.out.println("testSolutionUF_2: " + (passed ? "passed" : "failed"));
    }
}