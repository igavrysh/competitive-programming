class Solution {
   public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i] -> last index of lis in [0...i]
        int[] dp = new int[n];
        int length = 1;
        dp[0] = nums[0];
        for(int i=1;i<n;i++) {
            if(nums[i] > dp[length - 1]) {
                dp[length++] = nums[i];
            } else {
                int j = length-1;
                while (j >=0 && dp[j] >= nums[i]) {
                    j--;
                }
                dp[j+1] = nums[i];
            }
        }
        return length;
    }
}