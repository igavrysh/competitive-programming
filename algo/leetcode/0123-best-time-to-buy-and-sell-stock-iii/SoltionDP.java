public class SoltionDP {
    public int maxProfit(int[] prices) {
		int N = prices.length;
		int[][] DP = new int[2][N];
		for (int k = 0; k < 2; k++) {
			int maxLeft = Integer.MIN_VALUE;
            for (int i = 1; i < N; i++) {
                maxLeft = Math.max(maxLeft, (k-1 >= 0 && i-2 >= 0 ? DP[k-1][i-2] : 0) - (i-1 >= 0 ? prices[i-1] : 0));
                int maxProfit = prices[i] + maxLeft;
				DP[k][i] = Math.max(i-1 >= 0 ? DP[k][i-1] : 0, maxProfit);
			}
		} 
		return Math.max(0, Math.max(DP[0][N-1], DP[1][N-1]));
    }

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	public static void test1() {
		int[] prices = {3,3,5,0,0,3,1,4};
		int expectedOutput = 6;
		SoltionDP sol = new SoltionDP();
		int output = sol.maxProfit(prices);
		boolean passed = output == expectedOutput;
		System.out.println("test1: " + (passed ? "passed" : "failed"));
	}

	public static void test2() {
		int[] prices = {1,2,3,4,5};
		int expectedOutput = 4;
		SoltionDP sol = new SoltionDP();
		int output = sol.maxProfit(prices);
		boolean passed = output == expectedOutput;
		System.out.println("test2: " + (passed ? "passed" : "failed"));
	}

	public static void test3() {
		int[] prices = {7,6,4,3,1};
		int expectedOutput = 0;
		SoltionDP sol = new SoltionDP();
		int output = sol.maxProfit(prices);
		boolean passed = output == expectedOutput;
		System.out.println("test3: " + (passed ? "passed" : "failed"));
	}

}
