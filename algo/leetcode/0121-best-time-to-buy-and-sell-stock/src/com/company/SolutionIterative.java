package com.company;

public class SolutionIterative {

  public int maxProfit(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }

    int[] increments = new int[prices.length-1];
    for (int i = 0; i < increments.length; i++) {
      increments[i] = prices[i+1] - prices[i];
    }

    int[] dp = new int[increments.length];
    dp[0] = increments[0];
    for (int i = 1; i < increments.length; i++) {
      dp[i] = Math.max(dp[i - 1] + increments[i], increments[i]);
    }

    int output = 0;
    for (int i = 0; i < dp.length; i++) {
      if (output < dp[i]) {
        output = dp[i];
      }
    }
    return output;
  }
}
