import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Solution3 {
    public HashMap<Integer, HashSet<Integer>> graph(int N, int[] A, int[]B) {
        HashMap<Integer, HashSet<Integer>> G = new HashMap<>();
        for (int i = 0; i < N; i++) {
            G.put(i, new HashSet<>());
        }

        for (int i = 0; i < A.length; i++) {
            HashSet<Integer> adj = G.get(A[i]-1);
            adj.add(B[i]-1);
            G.put(A[i]-1, adj);
        }
        return G;
    }

    public HashMap<Integer, HashSet<Integer>> reverse(int N, HashMap<Integer, HashSet<Integer>> G) {
        HashMap<Integer, HashSet<Integer>> revG = new HashMap<>();
        for (int i = 0; i < N; i++) {
            revG.put(i, new HashSet<>());
        }
        for (Integer from : G.keySet()) {
            HashSet<Integer> adj = G.get(from);
            for (Integer to : adj) {
                HashSet<Integer> revAdj = revG.getOrDefault(to, new HashSet<>());
                revAdj.add(from);
                revG.put(to, revAdj);
            }
        }
        return revG;
    }

    private Stack<Integer> dfsPostOrder(int N, HashMap<Integer, HashSet<Integer>> G) {
        Stack<Integer> order = new Stack<>();
        boolean[] visited = new boolean[N];
        for (int v = 0; v < N; v++) {
            if (!visited[v]) {
                dfsPostOrderHelper(v, visited, order, N, G);
            }
        }
        return order;
    }

    private void dfsPostOrderHelper(Integer v, boolean[] visited, Stack<Integer> order, 
        int N, HashMap<Integer, HashSet<Integer>> G
    ) {
        visited[v] = true;
        HashSet<Integer> adj = G.get(v);
        for (Integer w : adj) {
            if (!visited[w]) {
                dfsPostOrderHelper(w, visited, order, N, G);
            }
        }
        order.push(v);
    }

    private void compact(int N, HashMap<Integer, HashSet<Integer>> G, int[] id, int[] weight, int newN, HashMap<Integer, HashSet<Integer>> compG, int[] newWeight) {
        for (int i = 0; i < newN; i++) {
            compG.put(i, new HashSet<>());
            newWeight[i] = 1;
        }
        for (Integer from : G.keySet()) {
            HashSet<Integer> adj = G.get(from);
            int fromP = id[from];
            for (Integer to : adj) {
                int toP = id[to];
                newWeight[toP] = weight[to];
                newWeight[fromP] = weight[from];

                if (fromP == toP) {
                    continue;
                }
                HashSet<Integer> adjP = compG.getOrDefault(fromP, new HashSet<Integer>());
                adjP.add(toP);
                compG.put(fromP, adjP);
                
            }
        }
    }

    private int KosarajuSCC(int N, HashMap<Integer, HashSet<Integer>> G, int[] id, int[] weight) {
        HashMap<Integer, HashSet<Integer>> revG = reverse(N, G);
        Stack<Integer> order = dfsPostOrder(N, revG);
        boolean[] visited = new boolean[N];
        boolean[] visited2 = new boolean[N];
        int newId = 0;
        while (!order.isEmpty()) {
            Integer s = order.pop();
            if (!visited[s]) {
                int[] counter = {0};
                dfsKosarajuSCC(s, visited, id, weight, newId++, N, G, counter, false);
                dfsKosarajuSCC(s, visited2, id, weight, -1, N, G, counter, true);
            }
        }
        return newId;
    }

    private int dfsKosarajuSCC(int v, boolean[] visited, int[] id, int[] weight, int newId,
        int N, HashMap<Integer, HashSet<Integer>> G, int[] counter, boolean updateCount
    ) {
        visited[v] = true;
        if (updateCount) {
            weight[v] = counter[0]; 
        } else {
            id[v] = newId;
            counter[0]++;
        }
        HashSet<Integer> adj = G.get(v);
        for (Integer w : adj) {
            if (!visited[w]) {
                dfsKosarajuSCC(w, visited, id, weight, newId, N, G, counter, updateCount);
            }
        }
        return counter[0];
    }

    public int getMaxVisitableWebpages(int N, int M, int[] A, int[] B) {
        HashMap<Integer, HashSet<Integer>> _G = graph(N, A, B);
        int[] _id = new int[N];
        int[] _weight = new int[N];
        int counter = KosarajuSCC(N, _G, _id, _weight);

        HashMap<Integer, HashSet<Integer>> G = new HashMap<>();
        int[] weight = new int[counter];
        compact(N, _G, _id, _weight, counter, G, weight);

        N = counter;

        int[] indegree = new int[N];
        for (Integer v : G.keySet()) {
            HashSet<Integer> adj = G.get(v);
            for (Integer w : adj) {
                indegree[w]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        int[] longestPath = new int[N];

        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }

            longestPath[i] = weight[i];
        }

        while (!q.isEmpty()) {
            Integer v = q.poll();
            HashSet<Integer> adj = G.get(v);
            for (Integer w : adj) {
                longestPath[w] = Math.max(longestPath[w], longestPath[v] + weight[w]);
                indegree[w]--;
                if (indegree[w] == 0) {
                    q.offer(w);
                }
            }
        }

        int maxDist = 1;
        
        for (int i = 0; i < N; i++) {
            maxDist = Math.max(maxDist, longestPath[i]);
        }

        return maxDist;
    }

    public static void main(String[] args) {
        test10();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
    }

    public static void test1() {
        int N = 4;
        int M = 4;
        int[] A = {1,2,3,4};
        int[] B = {4,1,2,1};
        int expectedOutput = 4;
        Solution3 sol = new Solution3();
        int output = sol.getMaxVisitableWebpages(N, M, A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 5;
        int M = 6;
        int[] A = {3,5,3,1,3,2};
        int[] B = {2,1,2,4,5,4};
        int expectedOutput = 4;
        Solution3 sol = new Solution3();
        int output = sol.getMaxVisitableWebpages(N, M, A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int N = 10;
        int M = 9;
        int[] A = {3,2,5,9,10,3,3,9,4};
        int[] B = {9,5,7,8, 6,4,5,3,9};
        int expectedOutput = 5;
        Solution3 sol = new Solution3();
        int output = sol.getMaxVisitableWebpages(N, M, A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int N = 2;
        int M = 2;
        int[] A = {1,2};
        int[] B = {1,2};
        int expectedOutput = 1;
        Solution3 sol = new Solution3();
        int output = sol.getMaxVisitableWebpages(N, M, A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        int N = 2;
        int M = 1;
        int[] A = {1};
        int[] B = {2};
        int expectedOutput = 2;
        Solution3 sol = new Solution3();
        int output = sol.getMaxVisitableWebpages(N, M, A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }

    public static void test6() {
        int N = 8;
        int M = 12;
        int[] A = {1,2,3,2,4,3,5,6,8,7,8,5};
        int[] B = {2,3,4,4,1,5,7,7,5,8,6,6};
        int expectedOutput = 8;
        Solution3 sol = new Solution3();
        int output = sol.getMaxVisitableWebpages(N, M, A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test6: " + (passed ? "passed" : "failed"));
    }

    public static void test7() {
        int N = 6;
        int M = 6;
        int[] A = {1,1,1,1,1};
        int[] B = {2,3,4,5,6};
        int expectedOutput = 2;
        Solution3 sol = new Solution3();
        int output = sol.getMaxVisitableWebpages(N, M, A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test7: " + (passed ? "passed" : "failed"));
    }

    public static void test8() {
        int N = 6;
        int M = 6;
        int[] A = {1,1,1,1,1,6};
        int[] B = {2,3,4,5,6,1};
        int expectedOutput = 3;
        Solution3 sol = new Solution3();
        int output = sol.getMaxVisitableWebpages(N, M, A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test8: " + (passed ? "passed" : "failed"));
    }

    public static void test9() {
        int N = 12;
        int M = 1;
        int[] A = {1};
        int[] B = {2};
        int expectedOutput = 2;
        Solution3 sol = new Solution3();
        int output = sol.getMaxVisitableWebpages(N, M, A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test9: " + (passed ? "passed" : "failed"));
    }

    public static void test10() {
        int N = 12;
        int M = 4;
        int[] A = {1,2,3,4};
        int[] B = {2,3,4,1};
        int expectedOutput = 4;
        Solution3 sol = new Solution3();
        int output = sol.getMaxVisitableWebpages(N, M, A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test10: " + (passed ? "passed" : "failed"));
    }
}
