package com.company;

public class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int[][] DP = new int[obstacleGrid.length][obstacleGrid[0].length];
    if (obstacleGrid[0][0] == 0) {
      DP[0][0] = 1;
    }
    for (int i = 0; i < DP.length; i++) {
      for (int j = 0; j < DP[0].length; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        if (obstacleGrid[i][j] == 0) {
          DP[i][j] = (j-1 >= 0 ? DP[i][j-1] : 0)
              + (i-1 >= 0 ? DP[i-1][j] : 0);
        }
      }
    }
    return DP[DP.length-1][DP[0].length-1];
  }
}
