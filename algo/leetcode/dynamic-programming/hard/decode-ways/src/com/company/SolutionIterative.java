package com.company;

public class SolutionIterative {
  public int numDecodings(String s) {

    int[] dp = new int[s.length()];

    if (s.length() == 0) {
      return 0;
    }
    int first = Integer.valueOf(s.substring(0, 1));
    dp[0] = first == 0 ? 0 : 1;
    if (s.length() == 1) {
      return dp[0];
    }
    int second = Integer.valueOf(s.substring(1, 2));
    int secondNum = Integer.valueOf(s.substring(0, 2));
    if (second > 0) {
      dp[1] += dp[0];
    }
    if (secondNum >= 10 && secondNum <= 26) {
      dp[1] += 1;
    }

    for (int i = 2; i < s.length(); i++) {
      int firstDigit = Integer.valueOf(s.substring(i, i + 1));
      if (firstDigit != 0) {
        dp[i] += dp[i - 1];
      }

      int secondDigit = Integer.valueOf(s.substring(i - 1, i + 1));
      if (secondDigit >= 10 && secondDigit <= 26) {
        dp[i] += dp[i - 2];
      }

    }
    return dp[dp.length - 1];
  }
}


// 2, 26, 2,2,6  22, 6