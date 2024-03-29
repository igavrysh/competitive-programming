import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;


class SolutionBuggy {

    public HashMap<Integer, ArrayList<Integer>> graph(int N, int[] A, int[]B) {
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

    public HashMap<Integer, ArrayList<Integer>> reverse(int N, HashMap<Integer, ArrayList<Integer>> G) {
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
        for (int v = 0; v < N; v++) {
            if (!visited[v]) {
                dfsPostOrderHelper(v, visited, order, N, G);
            }
        }
        return order;
    }

    private void dfsPostOrderHelper(Integer v, boolean[] visited, Stack<Integer> order, int N, HashMap<Integer, ArrayList<Integer>> G) {
        visited[v] = true;
        ArrayList<Integer> adj = G.get(v);
        for (Integer w : adj) {
            if (!visited[w]) {
                dfsPostOrderHelper(w, visited, order, N, G);
            }
        }
        order.push(v);
    }

    private void KosarajuSCC( int N, HashMap<Integer, ArrayList<Integer>> G, int[] id, int[] weight) {
        HashMap<Integer, ArrayList<Integer>> revG = reverse(N, G);
        Stack<Integer> order = dfsPostOrder(N, revG);
        boolean[] visited = new boolean[N];
        boolean[] visited2 = new boolean[N];
        while (!order.isEmpty()) {
            Integer s = order.pop();
            if (!visited[s]) {
                int[] counter = {0};
                dfsKosarajuSCC(s, visited, id, weight, s, N, G, counter, false);
                dfsKosarajuSCC(s, visited2, id, weight, -1, N, G, counter, true);
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
            counter[0] = counter[0] + 1;
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

        ArrayList<Integer> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(i);
        }
        G.put(N, adj);
        id[N] = N;
        weight[N] = 0;

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> adj2 = G.get(i);
            adj2.add(N+1);
        }
        G.put(N+1, new ArrayList<>());
        id[N+1] = N+1;
        weight[N+1] = 0;

        int[] dist = new int[N+2];
        for (int i = 0; i < N+2; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        Stack<Integer> order = dfsPostOrder(N+2, G);

        dist[N] = 0;
        while (!order.isEmpty()) {
            Integer v = order.pop();
            Integer vP = id[v];
            for (Integer w : G.get(v)) {
                Integer wP = id[w];
                Integer weightWP = wP != vP ? weight[wP] : 0;
                if (dist[wP] > dist[vP] + weightWP) {
                    dist[wP] = dist[vP] + weightWP;
                }
            }
        }
        return -1*dist[N+1];
    }

    public static void testGenerateRandom() {
        int N = 25;
        int SAMPLE_SIZE = 1000;
        int currSize = 0;
        boolean stop = false;

        long startS1, finishS1;
        ArrayList<Double> ratiosS1 = new ArrayList<>();
        long startS2, finishS2;
        ArrayList<Double> ratiosS2 = new ArrayList<>();


        for (int k = 1; k < N*(N-1) / 2; k++) {
            int M = k;
            int[] A = new int[M];
            int[] B = new int[M];
            if (stop) {
                break;
            }
            currSize = 0;
            while (currSize++ < SAMPLE_SIZE && !stop) {
                for (int i = 0; i < M; i++) {
                    boolean seen = true;
                    while (seen) {
                        seen = false;
                        int ai = ThreadLocalRandom.current().nextInt(1, N+1);
                        int bi = ThreadLocalRandom.current().nextInt(1, N+1);

                        for (int j = 0; j < i; j++) {
                            if (A[j] == ai && B[j] == bi) {
                                seen = true;
                                break;
                            }
                        }

                        if (!seen) {
                            A[i] = ai;
                            B[i] = bi;
                        }
                    }
                }

                startS1 = System.nanoTime();
                SolutionBuggy sol1 = new SolutionBuggy();
                int outputSol1 = sol1.getMaxVisitableWebpages(N, M, A, B);
                finishS1 = System.nanoTime();
                ratiosS1.add((finishS1-startS1*1.0)/(N+M));

                startS2 = System.nanoTime();
                SolutionNegWeightLongestPath sol2 = new SolutionNegWeightLongestPath();
                int outputSol2 = sol2.getMaxVisitableWebpages(N, M, A, B);
                finishS2 = System.nanoTime();
                ratiosS2.add((finishS2-startS2*1.0)/(N+M));

                //System.out.println("---");
                //printAB(A, B);
                //System.out.println("sol1 output = " + outputSol1 + "; sol2 output = " + outputSol2);


                if (outputSol1 != outputSol2) {
                    System.out.println("Not matching - ERROR!!!");
                    printAB(A, B);
                    stop = true;
                } else {
                    //System.out.println("testGenerateRandom matching!");
                }
            }
        }
        int tmp = 1;
    }

    private static void printAB(int[] A, int[] B) {
        System.out.print("A: ");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }

        System.out.print("\nB: ");
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        testGenerateRandom();
        /*
        test0();
        test8();
        test7();
        test6();
        test1();
        test2();
        test3();
        test4();
        test5();
        test9();
        test10();
        */
    }

    public static void test0() {
        int N = 2;
        int M = 2;
        int[] A = {1,2};
        int[] B = {2,1};
        int expectedOutput = 2;
        SolutionBuggy sol = new SolutionBuggy();
        int output = sol.getMaxVisitableWebpages(N, M, A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test0: " + (passed ? "passed" : "failed"));
    }

    public static void test1() {
        int N = 4;
        int M = 4;
        int[] A = {1,2,3,4};
        int[] B = {4,1,2,1};
        int expectedOutput = 4;
        SolutionBuggy sol = new SolutionBuggy();
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
        SolutionBuggy sol = new SolutionBuggy();
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
        SolutionBuggy sol = new SolutionBuggy();
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
        SolutionBuggy sol = new SolutionBuggy();
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
        SolutionBuggy sol = new SolutionBuggy();
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
        SolutionBuggy sol = new SolutionBuggy();
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
        SolutionBuggy sol = new SolutionBuggy();
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
        SolutionBuggy sol = new SolutionBuggy();
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
        SolutionBuggy sol = new SolutionBuggy();
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
        SolutionBuggy sol = new SolutionBuggy();
        int output = sol.getMaxVisitableWebpages(N, M, A, B);
        boolean passed = output == expectedOutput;
        System.out.println("test10: " + (passed ? "passed" : "failed"));
    }
}
