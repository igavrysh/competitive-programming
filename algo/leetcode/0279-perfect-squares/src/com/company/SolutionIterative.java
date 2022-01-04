package com.company;

public class SolutionIterative {
  public int numSquares(int n) {
    int[] dp = new int[n+1];
    dp[0] = 0;
    if (dp.length >= 2) {
      dp[1] = 1;
    }
    for (int i = 2; i < dp.length; i++) {
      int i_sqrt = (int)Math.sqrt(i);
      int min = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        int current = dp[i - j * j] + 1;
        if (current < min) {
          min = current;
        }
      }
      dp[i] = min;
    }
    return dp[n];
  }
}
