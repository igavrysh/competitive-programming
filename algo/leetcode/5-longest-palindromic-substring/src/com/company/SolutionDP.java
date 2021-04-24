package com.company;

public class SolutionDP {
  public String longestPalindrome(String s) {
    int[] DP = new int[s.length()];
    int[] DP2 = new int[s.length()];
    for (int i = 0; i < DP.length; i++) {
      DP[i] = 1;
    }
    int max = 1;
    int endMaxI = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i > 0 && i-DP[i-1]-1 >= 0) {
        if (s.charAt(i) == s.charAt(i-DP[i-1]-1)) {
          DP[i] = DP[i-1] + 2;
        }
        if (DP[i] > max) {
          max = DP[i];
          endMaxI = i;
        }
      }
      if (i > 0 && i-DP2[i-1]-1 >= 0) {
        if (s.charAt(i) == s.charAt(i-DP2[i-1]-1)) {
          DP2[i] = DP2[i-1] + 2;
        }
        if (DP2[i] > max) {
          max = DP2[i];
          endMaxI = i;
        }
      } else if (i-1 >= 0 && s.charAt(i) == s.charAt(i-1)) {
        DP2[i] = 2;
        if (DP2[i] > max) {
          max = DP2[i];
          endMaxI = i;
        }
      }
    }
    return s.substring(endMaxI+1-max, endMaxI+1);
  }
}


