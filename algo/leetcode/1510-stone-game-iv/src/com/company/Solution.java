package com.company;

public class Solution {
  public boolean winnerSquareGame(int n) {
    boolean[] DP = new boolean[n+1];
    for (int i = 1; i <= n; i++) {
      int iSqrt = (int)Math.sqrt(i);
      if (Math.pow(iSqrt, 2.0) == i) {
        DP[i] = true;
        continue;
      }

      boolean updated = false;
      for (int s = iSqrt; s >= 1; s--) {
        int sSq = (int)Math.pow(s, 2.0);
        if (DP[i-sSq] == false) {
          DP[i]=true;
          updated=true;
          break;
        }
      }
      if (!updated) {
        DP[i]=false;
      }
    }
    return DP[n];
  }
}
