package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int numberOfMatches(int n) {
    int[] DP = new int[n+1];
    DP[0] = 0;
    DP[1] = 0;
    for (int i = 2; i <= n; i++) {
      DP[i] = (i / 2) + DP[ i / 2 + i %2];
    }
    return DP[n];
  }
}
