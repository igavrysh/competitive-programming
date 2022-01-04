package com.company;

public class SolutionDPIncr {
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }

    int[] p = new int[prices.length - 1];
    for (int i = 0; i < prices.length-1; i++) {
      p[i] = prices[i + 1] - prices[i];

    }

    int[][] dp = new int[p.length][2];
    dp[0][0] = 0;
    dp[0][1] = p[0];
    if (dp.length == 1) {
      return Math.max(dp[0][1], dp[0][0]);
    }
    dp[1][0] = Math.max(dp[0][0], dp[0][1]);
    dp[1][1] = Math.max(dp[0][0] + p[1], dp[0][1] + p[1]);


    for (int i = 2; i < dp.length; i++) {
      int dp_i0 = Math.max(dp[i-1][1], dp[i-1][0]);
      int dp_i1 = dp[i-1][1] + p[i];
      if (i >= 3) {
        dp_i1 = Math.max(dp_i1, Math.max(dp[i-3][0] + p[i], dp[i-3][1] + p[i]));
      } else if (i == 2) {
        dp_i1 = Math.max(dp_i1, p[i]);
      }
      dp[i][0] = dp_i0;
      dp[i][1] = dp_i1;
    }

    int output = 0;
    for (int i = 0; i < dp.length; i++) {
      if (output <= Math.max(dp[i][0], dp[i][1])) {
        output = Math.max(dp[i][0], dp[i][1]);
      }
    }

    return output;
  }
}
