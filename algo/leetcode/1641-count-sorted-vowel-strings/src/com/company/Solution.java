package com.company;

public class Solution {
  public int countVowelStrings(int n) {
    int vowels = 5;
    int[][] DP = new int[vowels+1][n+1];
    for (int j = 0; j <= n; j++) {
      for (int i = 0; i <= vowels; i++) {
        if (i == 0 || j == 0) {
          DP[i][j] = 0;
        } else if (i == 1 ) {
          DP[i][j] = 1;
        } else if (j == 1) {
          DP[i][j] = i;
        } else {
          int value = 0;
          for (int ii = 1; ii <= i; ii++) {
            value += DP[ii][j-1];
          }
          DP[i][j] = value;
        }
      }
    }
    return DP[vowels][n];
  }

}
