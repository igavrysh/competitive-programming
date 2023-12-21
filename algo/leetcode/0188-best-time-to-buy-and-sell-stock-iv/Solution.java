class Solution {
    public int maxProfit(int K, int[] prices) {
        int maxProfit = 0;
        int N = prices.length;
        int[] DP = new int[N];
        int DPprevK_i = 0;
        int DPprevK_i_m1 = 0;
        int DPprevK_i_m2 = 0;
        for (int k = 1; k <= K; k++) {
            DPprevK_i = DP[0];
            DPprevK_i_m1 = 0;
            DPprevK_i_m2 = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < N; i++) {
                DPprevK_i_m2 = DPprevK_i_m1;
                DPprevK_i_m1 = DPprevK_i;
                DPprevK_i = DP[i];
                DP[i] = Math.max(DP[i-1], max + prices[i]);
                max = Math.max(max, DPprevK_i_m2 - prices[i-1]);
            }
            maxProfit = Math.max(maxProfit, DP[N-1]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int[] prices = {3,2,6,5,0,3};
        int K = 2;
        int DPprevK_i_m1 = 2;
        int expOutput = 7;
        Solution sol = new Solution();
        int output = sol.maxProfit(K, prices);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}