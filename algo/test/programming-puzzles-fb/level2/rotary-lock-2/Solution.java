import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        testRandom();
    }

    public long getMinCodeEntryTime(int N, int M, int[] C) {
        HashMap<Integer, Long> dis = new HashMap<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((int[] idxs1, int[] idxs2) -> {
            long d1 = dis.getOrDefault(key(idxs1), Long.MAX_VALUE);
            long d2 = dis.getOrDefault(key(idxs2), Long.MAX_VALUE);
            return Long.compare(d1, d2);
        });

        // Dijkstra algorithm
        int[] initialState = new int[]{0,0};
        dis.put(key(initialState), 0L);
        q.offer(initialState);
        long distanceToFinalState = Long.MAX_VALUE;
        while (!q.isEmpty() && dis.getOrDefault(key(q.peek()), Long.MAX_VALUE) <= distanceToFinalState ) {
            int[] state = q.poll();
            if (state[1] == M) {
                distanceToFinalState = Math.min(distanceToFinalState, dis.getOrDefault(key(state), Long.MAX_VALUE));
            }

            int currKey = key(state);
            long currDis = dis.get(currKey);

            if (state[1] < M) {
                long stateCl0 = state[0] == 0 ? 1 : C[state[0]-1];
                long stateCl1 = state[1] == 0 ? 1 : C[state[1]-1];
                long stateC = C[state[1] == 0 ? 0 : state[1]];

                int[] newState = new int[]{state[1], state[1]+1};
                int keyNewState = key(newState);
                long delta = 0;
                if (stateC >= stateCl0) {
                    delta = Math.min(stateC - stateCl0, stateCl0 + N - stateC);
                } else {
                    delta = Math.min(stateCl0 - stateC , stateC + N - stateCl0);
                }

                Long oldDist = dis.get(keyNewState) ;
                if (oldDist == null || oldDist > currDis+delta) {
                    if (oldDist == null) {
                        q.remove(newState);
                    }
                    dis.put(keyNewState, currDis+delta);
                    q.offer(newState);
                }
                
                newState = new int[]{state[0], state[1]+1};
                keyNewState = key(newState);
                delta = 0;
                if (stateC >= stateCl1) {
                    delta = Math.min(stateC - stateCl1, stateCl1 + N - stateC);
                } else {
                    delta = Math.min(stateCl1 - stateC , stateC + N - stateCl1);
                }
                oldDist = dis.get(keyNewState) ;
                if (oldDist == null || oldDist > currDis+delta) {
                    if (oldDist == null) {
                        q.remove(newState);
                    }
                    dis.put(keyNewState, currDis+delta);
                    q.offer(newState);
                }
            }
        }
        return distanceToFinalState;
    }

    private int key(int[] idxs) {
        return idxs[0] * 10000 + idxs[1];
    }
    
    public static void test3() {
        int N = 10;
        int M = 5;
        int[] C = {2,5,8,5,4};
        long expectedOutput = 8;
        Solution sol = new Solution();
        long output = sol.getMinCodeEntryTime(N, M, C);
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test1() {
        int N = 3;
        int M = 3;
        int[] C = {1,2,3};
        long expectedOutput = 2;
        Solution sol = new Solution();
        long output = sol.getMinCodeEntryTime(N, M, C);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 10;
        int M = 4;
        int[] C = {9,4,4,8};
        long expectedOutput = 6;
        Solution sol = new Solution();
        long output = sol.getMinCodeEntryTime(N, M, C);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void testRandom() {
        int N = 1000000000;
        int M = 3000;
        int[] C = new int[M];
        for (int i = 0; i < M; i++) {
            C[i] = ThreadLocalRandom.current().nextInt(1, N + 1);
        }

        long startTime = System.nanoTime();
        Solution s = new Solution();
        long output = s.getMinCodeEntryTime(N, M, C);
        System.out.println("testRandom, output = " + String.valueOf(output));
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Solution execution time for testRandom: "
            + elapsedTime/1000000000.0 + "s");
    }

}
