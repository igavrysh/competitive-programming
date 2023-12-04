import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;

class Solution {

    private HashMap<Integer, ArrayList<Integer>> graph(int N, int[] A, int[]B) {
        HashMap<Integer, ArrayList<Integer>> G = new HashMap<>();
        for (int i = 0; i < N; i++) {
            G.put(i, new ArrayList<>());
        }

        for (int i = 0; i < A.length; i++) {
            ArrayList<Integer> adj = G.getOrDefault(A[i]-1, new ArrayList<>());
            adj.add(B[i]-1);
            G.put(A[i]-1, adj);
        }
        return G;
    }

    private HashMap<Integer, ArrayList<Integer>> reverse(int N, HashMap<Integer, ArrayList<Integer>> G) {
        HashMap<Integer, ArrayList<Integer>> revG = new HashMap<>();
        for (int i = 0; i < N; i++) {
            revG.put(i, new ArrayList<>());
        }

        for (Integer from : G.keySet()) {
            ArrayList<Integer> adj = G.get(from);
            for (Integer to : adj) {
                ArrayList<Integer> revAdj = revG.getOrDefault(to, new ArrayList<>());
                revAdj.add(from);
                revG.put(to, revAdj);
            }
        }
        return revG;
    }

    private Stack<Integer> dfsPostOrder(int N, HashMap<Integer, ArrayList<Integer>> G) {
        Stack<Integer> order = new Stack<>();
        boolean[] visited = new boolean[N];
        dfsPostOrderHelper(0, visited, order, N, G);
        return order;
    }

    private void dfsPostOrderHelper(Integer v, boolean[] visited, Stack<Integer> order, 
        int N, HashMap<Integer, ArrayList<Integer>> G
    ) {
        visited[v] = true;
        ArrayList<Integer> adj = G.get(v);
        for (Integer w : adj) {
            if (!visited[w]) {
                dfsPostOrderHelper(w, visited, order, N, G);
            }
        }
        order.add(v);
    }

    private void KosarajuSCC( int N, HashMap<Integer, ArrayList<Integer>> G, int[] id, int[] weight) {
        HashMap<Integer, ArrayList<Integer>> revG = reverse(N, G);
        Stack<Integer> order = dfsPostOrder(N, revG);
        boolean[] visited = new boolean[N];
        boolean[] visited2 = new boolean[N];
        for (Integer s : order) {
            if (!visited[s]) {
                int[] counter = {0};
                dfsKosarajuSCC(s, visited, id, weight, s, N, G, counter, false);
                dfsKosarajuSCC(s, visited2, id, weight, s, N, G, counter, true);
            }
        }
    }

    private void dfsKosarajuSCC(int v, boolean[] visited, int[] id, int[] weight, int newId,
        int N, HashMap<Integer, ArrayList<Integer>> G, int[] counter, boolean updateCount
    ) {
        visited[v] = true;
        if (updateCount) {
            weight[v] = counter[0]; 
        } else {
            id[v] = newId;
            counter[0]++;
        }
        ArrayList<Integer> adj = G.get(v);
        for (Integer w : adj) {
            if (!visited[w]) {
                dfsKosarajuSCC(w, visited, id, weight, newId, N, G, counter, updateCount);
            }
        }
    }

    public int getMaxVisitableWebpages(int N, int M, int[] A, int[] B) {
        HashMap<Integer, ArrayList<Integer>> G = graph(N, A, B);
        int[] id = new int[N+2];
        int[] weight = new int[N+2];
        KosarajuSCC(N, G, id, weight);
        for (int i = 0; i < N; i++) {
            weight[i] *= -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int N = 4;
        int M = 4;
        int[] A = {1,2,3,4};
        int[] B = {4,1,2,1};
        int expectedOutput = 4;
        Solution sol = new Solution();
        int output = sol.getMaxVisitableWebpages(N, M, A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}
