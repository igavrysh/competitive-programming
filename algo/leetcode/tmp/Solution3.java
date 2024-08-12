public class Solution3 {
    private static final int MOD = 1000000007;

    public static int countMonotonicPairs(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][nums[0] + 1];

        // Initialize the first row of dp
        for (int j = 0; j <= nums[0]; j++) {
            dp[0][j] = 1;
        }

        // Fill the dp array
        for (int i = 1; i < n; i++) {
            int[][] newDp = new int[n][nums[i] + 1];
            int sum = 0;
            for (int j = 0; j <= nums[i]; j++) {
                int arr2Value = nums[i] - j;
                if (arr2Value >= 0) {
                    sum = (sum + dp[i - 1][j]) % MOD;
                    newDp[i][j] = sum;
                }
            }
            dp = newDp;
        }

        // Sum all valid sequences at the last position
        int result = 0;
        for (int j = 0; j <= nums[n - 1]; j++) {
            result = (result + dp[n - 1][j]) % MOD;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(countMonotonicPairs(nums));  // Output: Expected result depending on input nums
    }
}
