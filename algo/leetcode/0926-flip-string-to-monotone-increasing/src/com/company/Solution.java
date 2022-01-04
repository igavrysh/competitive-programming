package com.company;

public class Solution {
  public int minFlipsMonoIncr(String s) {
    int[] DP0 = new int[s.length()];
    int[] DP1 = new int[s.length()];
    int acc0 = 0;
    int acc1 = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        acc1 += 1;
      }
      DP1[i] = acc1;
      if (s.charAt(s.length()-1-i) == '0') {
        acc0 += 1;
      }
      DP0[s.length()-1-i] = acc0;
    }
    int output = Math.min(DP0[0], DP1[DP1.length-1]);
    for (int i = 1; i < DP0.length; i++) {
      output = Math.min(DP0[i] + DP1[i-1], output);
    }
    return output;
  }
}
