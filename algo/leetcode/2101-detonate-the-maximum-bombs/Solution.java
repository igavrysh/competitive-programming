import java.util.HashSet;

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        HashSet<Integer>[] G = createGraph(bombs);

        int globlMax = 0;
        for (int i = 0; i < n; i++) {
            globlMax = Math.max(globlMax, DFS(i, G));
        }

        return globlMax;
    }

    private HashSet<Integer>[] createGraph(int[][] bombs) {
        int n = bombs.length;
        @SuppressWarnings("unchecked")
        HashSet<Integer>[] G = new HashSet[n];
        for (int i = 0; i < n; i++) {
            G[i] = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                double d = Math.sqrt(
                    Math.pow(bombs[i][0] - bombs[j][0], 2.0)
                    + Math.pow(bombs[i][1] - bombs[j][1], 2.0)
                );
                if (d <= bombs[i][2]) {
                    G[i].add(j);
                }
            }
        }
        return G;
    }

    private int DFS(int start, HashSet<Integer>[] G) {
        int n = G.length;
        boolean[] visited = new boolean[n];
        visited[start] = true;
        int[] res = {0};
        _DFS(start, G, visited, res);
        return res[0];
    }

    private void _DFS(int node, HashSet<Integer>[] G, boolean[] visisted, int[] counter) {
        counter[0]++;
        HashSet<Integer> nghbrs = G[node];
        for (Integer nghbr : nghbrs) {
            if (!visisted[nghbr]) {
                visisted[nghbr] = true;
                _DFS(nghbr, G, visisted, counter);
            }
        }
    }

    public static void main(String[] args) {
        testSolution_1();
    }

    public static void testSolution_1() {
        int[][] bombs = {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
        int expOutput = 5;
        Solution s = new Solution();
        int output = s.maximumDetonation(bombs);
        boolean passed = expOutput == output;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }
}