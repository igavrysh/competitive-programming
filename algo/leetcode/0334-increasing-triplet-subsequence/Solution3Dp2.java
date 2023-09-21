// Time complexity: O(N^2)
// Space complexiyt: O(N)

public class Solution3Dp2 {

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        // DP[i] = longest inc subseq that ends with nums[i]
        int[] DP = new int[n];
        DP[0] = 1;

        int longestSeen = 1;

        for (int i = 1; i < n; i++) {
            int dp_i = 1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp_i = Math.max(dp_i, DP[j] + 1);


                    if (dp_i == 3) {
                        return true;
                    }


                    if (longestSeen == DP[j]) {
                        break;
                    }
                }
            }
            DP[i] = dp_i;
            longestSeen = Math.max(longestSeen, DP[i]);
        }
        return false;
    }
}
