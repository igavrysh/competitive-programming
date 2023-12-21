class Solution {
    public int maxProfit(int K, int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int N = prices.length;
        int[] DP = new int[N];
        int DPprevK_i = 0;
        int DPprevK_i_m1 = 0;
        int DPprevK_i_m2 = 0;
        for (int k = 1; k <= K; k++) {
            DPprevK_i = DP[1];
            DPprevK_i_m1 = DP[0];
            DPprevK_i_m2 = 0;
            int max = -prices[0];
            for (int i = 1; i < N; i++) {
                DPprevK_i_m2 = DPprevK_i_m1;
                DPprevK_i_m1 = DPprevK_i;
                DPprevK_i = DP[i];
                max = Math.max(max, DPprevK_i_m2 - prices[i-1]);
                
                DP[i] = Math.max(DP[i-1], max + prices[i]);
            }
            maxProfit = Math.max(maxProfit, DP[N-1]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        test4();
        test3();
        test1();
        test2();
    }

    public static void test1() {
        int[] prices = {3,2,6,5,0,3};
        int K = 2;
        int expOutput = 7;
        Solution sol = new Solution();
        int output = sol.maxProfit(K, prices);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] prices = {2,4,1};
        int K = 2;
        int expOutput = 2;
        Solution sol = new Solution();
        int output = sol.maxProfit(K, prices);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[] prices = {2,1,2,0,1};
        int K = 2;
        int expOutput = 2;
        Solution sol = new Solution();
        int output = sol.maxProfit(K, prices);
        boolean passed = output == expOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int[] prices = {1};
        int K = 2;
        int expOutput = 0;
        Solution sol = new Solution();
        int output = sol.maxProfit(K, prices);
        boolean passed = output == expOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}