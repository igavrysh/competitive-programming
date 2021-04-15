package com.company;

public class Solution {
  public int longestValidParentheses(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int[] DP = new int[s.length()];
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')' && i >= 1 && s.charAt(i - 1) == '(') {
        DP[i] = 2 + (i >= 2 ? DP[i - 2] : 0);
      }

      if (s.charAt(i) == ')' && i >= 1 && s.charAt(i - 1) == ')'
        && i-1-DP[i-1] >= 0 && s.charAt(i-1-DP[i-1]) == '(') {
        DP[i] = 2 + DP[i-1] + (i-1 - DP[i-1] - 1 >= 0 ? DP[i-1 - DP[i-1] - 1] : 0);

      }
      if (max < DP[i]) {
        max = DP[i];
      }
    }
    return max;
  }
}
