package com.company;

public class Solution {
  public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return nums[0];
    }

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
    }

    int output = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (output < dp[i]) {
        output = dp[i];
      }
    }

    return output;
  }
}
