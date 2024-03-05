class Solution {

    private void getMax(int idx, boolean isFirst, double[] globalMax, int N, int[] H, int[] D, int B) {
        double currMax = 0;
        int currMaxIdx = -1;
        for (int idx2 = 0; idx2 < N; idx2++) {
            if (idx == idx2) {
                continue;
            }

            double val = 0;
            if (isFirst) {
                val = ((double) D[idx]) * H[idx]
                        + ((double) H[idx]) * D[idx2]
                        + ((double) D[idx2]) * H[idx2];
            } else {
                val = ((double) D[idx2]) * H[idx2]
                        + ((double) H[idx2]) * D[idx]
                        + ((double) D[idx]) * H[idx];
            }

            if (currMax < val) {
                currMax = val;
                currMaxIdx = idx2;
            }
        }

        if (currMaxIdx != -1) {
            if (globalMax[0] < currMax) {
                globalMax[0] = currMax;
                getMax(currMaxIdx, !isFirst, globalMax, N, H, D, B);
            } else {
                return;
            }
        }
    }

    public double getMaxDamageDealt(int N, int[] H, int[] D, int B) {
        double[] globalMax1 = { 0D };
        double[] globalMax2 = { 0D };
        getMax(0, true, globalMax1, N, H, D, B);
        getMax(0, false, globalMax2, N, H, D, B);
        return Math.max(globalMax1[0], globalMax2[0]) / B;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int N = 3;
        int[] H = { 2, 1, 4 };
        int[] D = { 3, 1, 2 };
        int B = 4;
        double expectedOutput = 6.5;
        double delta = Math.pow(10, -6);
        Solution sol = new Solution();
        double output = sol.getMaxDamageDealt(N, H, D, B);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int N = 4;
        int[] H = { 1, 1, 2, 100 };
        int[] D = { 1, 2, 1, 3 };
        int B = 8;
        double expectedOutput = 62.75;
        double delta = Math.pow(10, -6);
        Solution sol = new Solution();
        double output = sol.getMaxDamageDealt(N, H, D, B);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int N = 4;
        int[] H = { 1, 1, 2, 3 };
        int[] D = { 1, 2, 1, 100 };
        int B = 8;
        double expectedOutput = 62.75;
        double delta = Math.pow(10, -6);
        Solution sol = new Solution();
        double output = sol.getMaxDamageDealt(N, H, D, B);
        boolean passed = Math.abs(output - expectedOutput) < delta;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

}