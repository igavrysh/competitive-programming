// Write any import statements here

class Solution {

    public long getMinCodeEntryTime(int N, int M, int[] C) {
        int state = 1;
        long time = 0;
        for (int i = 0; i < C.length; i++) {
            if (C[i] > state) {
                time += Math.min(C[i] - state, state + N-C[i]);
            }

            if (C[i] < state) {
                time += Math.min(state - C[i], C[i] + N-state);
            }

            state = C[i];
        }
        return time;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        int N = 3;
        int M = 3;
        int[] C = {1, 2, 3};
        long expectedOutput = 2;
        Solution s = new Solution();
        long output = s.getMinCodeEntryTime(N, M, C);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 10;
        int M = 4;
        int[] C = {9, 4, 4, 8};
        long expectedOutput = 11;
        Solution s = new Solution();
        long output = s.getMinCodeEntryTime(N, M, C);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

}
