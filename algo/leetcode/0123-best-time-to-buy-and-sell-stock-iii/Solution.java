
public class Solution {

	public int maxProfit(int[] prices) {
		int N = prices.length;
		int[][] DP = new int[2][N];
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < N; i++) {
				int maxProfit = 0;
				for (int j = 0; j < i; j++) {
					maxProfit = Math.max(maxProfit, (k-1 >= 0 && j-1 >= 0 ? DP[k-1][j-1] : 0) + prices[i] - prices[j]);
				}
				DP[k][i] = Math.max(i-1 >= 0 ? DP[k][i-1] : 0, maxProfit);
			}
		} 
		return Math.max(0, Math.max(DP[0][N-1], DP[1][N-1]));
    }

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		int[] prices = {3,3,5,0,0,3,1,4};
		int expectedOutput = 6;
		Solution sol = new Solution();
		int output = sol.maxProfit(prices);
		boolean passed = output == expectedOutput;
		System.out.println("test1: " + (passed ? "passed" : "failed"));
	}
}
