package com.company;

public class Solution {
  public int longestValidParentheses(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int[] DP = new int[s.length()];
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')' && s.charAt(i-1) == '(') {
        DP[i] = 2 + (i-2 >= 0 ? DP[i-2] : 0);
      }
      if (s.charAt(i) == ')' && s.charAt(i-1) == ')') {
        int remainder = (i-1)-DP[i-1]-1 >= 0 ? DP[(i-1)-DP[i-1]-1] : 0;
        DP[i] = DP[i-1]
            + (i-1-DP[i-1] < 0
              ? 0
              : s.charAt((i-1)-DP[i-1]) == '(' ? 2 + remainder : 0);
      }
    }

    int ans = DP[0];
    for (int i = 1; i < DP.length; i++) {
      if (DP[i] > ans) {
        ans = DP[i];
      }
    }
    return ans;
  }
}
