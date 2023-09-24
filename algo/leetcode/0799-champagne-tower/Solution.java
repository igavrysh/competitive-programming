class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        int l = 1;
        double[] dp = new double[1];
        dp[0] = poured;
        if (query_row == 0) {
            return Math.min(poured, 1);
        }
        for (int i = 1; i <= query_row; i++) {
            double[] new_dp = new double[l+1];
            for (int j = 0; j < l+1; j++) {
                if (j < l) {
                    new_dp[j] += Math.max((dp[j] - 1) / 2.0, 0);
                }
                if (j > 0) {
                    new_dp[j] += Math.max((dp[j-1] - 1) / 2.0, 0);
                }
            }
            l++;
            dp = new_dp;
        }
        return Math.min(dp[query_glass], 1);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        int poured = 2;
        int query_row = 1;
        int query_glass = 1;
        Solution s = new Solution();
        double output = s.champagneTower(poured, query_row, query_glass);
        double expected = 0.5;
        boolean passed = expected == output;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int poured = 100000009;
        int query_row = 33;
        int query_glass = 17;
        Solution s = new Solution();
        double output = s.champagneTower(poured, query_row, query_glass);
        double expected = 1.0;
        boolean passed = expected == output;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }
}