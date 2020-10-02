package com.company;

public class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }

    int[][] dp = new int[prices.length][2];
    dp[0][0] = dp[0][1] = 0;

    for (int i = 1; i < prices.length; i++) {
      int dp_i0 = dp[i-1][1] + prices[i] - prices[i-1];

      int dp_i1 = Math.max(
          dp[i-1][1] + prices[i] - prices[i-1],
          dp[i-1][0] + prices[i] - prices[i-1]
      );

      dp[i][0] = dp_i0;
      dp[i][1] = dp_i1;
    }

    int output = 0;
    for (int i = 0; i < dp.length; i++) {
      if (i == dp.length - 1) {
        if (output < dp[i][0]) {
          output = dp[i][0];
        }
      } else {
        if (output < Math.max(dp[i][0], dp[i][1])) {
          output = dp[i][1];
        }
      }
    }
    return output;
  }
}
