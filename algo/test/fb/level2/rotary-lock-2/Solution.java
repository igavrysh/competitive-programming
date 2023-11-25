class Solution {

    public long getMinCodeEntryTime(int N, int M, int[] C) {
        return BT(0, 0, new int[]{1,1}, N, M, C);
    }

    private long BT(int idx, long time, int[] state, int N, int M, int[] C) {
        if (idx == M) {
            return time;
        }

        if (C[idx] == state[0]) {
            return BT(idx+1, time, state, N, M, C);
        }

        if (C[idx] == state[1]) {
            return BT(idx+1, time, state, N, M, C);
        }

        long t1 = 0, t2 = 0;
        if (C[idx] > state[0]) {
            t1 = BT(idx+1, time + Math.min(C[idx] - state[0], state[0] + N- C[idx]), new int[]{C[idx], state[1]}, N, M, C);
        }

        if (C[idx] < state[0]) {
            t1 = BT(idx+1, time + Math.min(state[0] - C[idx], C[idx] + N-state[0]), new int[]{C[idx], state[1]}, N, M, C);
        }

        if (C[idx] > state[1]) {
            t2 = BT(idx+1, time + Math.min(C[idx] - state[1], state[1] + N- C[idx]), new int[]{state[0], C[idx]}, N, M, C);
        }

        if (C[idx] < state[1]) {
            t2 = BT(idx+1, time + Math.min(state[1] - C[idx], C[idx] + N-state[1]), new int[]{state[0], C[idx]}, N, M, C);
        }

        return Math.min(t1, t2);
    }

    public static void main(String[] args) {
        test1();
        test2();
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
}
