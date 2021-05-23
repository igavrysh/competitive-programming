package com.company;

public class Solution {
  public int minDistance(String word1, String word2) {
    int N1 = word1.length();
    int N2 = word2.length();
    int[][] DP = new int[N2 + 1][N1 + 1];
    for (int i = N1; i >= 0; i--) {
      DP[N2][i] = N1 - i;
    }
    for (int j = N2; j >= 0; j--) {
      DP[j][N1] = N2 - j;
    }

    for (int i = N1 - 1; i >= 0; i--) {
      for (int j = N2 - 1; j >= 0; j--) {
        DP[j][i] = (word1.charAt(i) == word2.charAt(j) ? 0 : 1) + DP[j + 1][i + 1];

        int deleteCost = 1 + DP[j][i + 1];
        if (DP[j][i] > deleteCost) {
          DP[j][i] = deleteCost;
        }

        int insertCost = 1 + DP[j + 1][i];
        if (DP[j][i] > insertCost) {
          DP[j][i] = insertCost;
        }
      }
    }
    return DP[0][0];
  }
}
