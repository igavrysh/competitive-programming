package com.company;

public class Solution {
  public int cherryPickup(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int[][][] DP = new int[rows][cols][cols];
    for (int j1 = 0; j1 < cols; j1++) {
      for (int j2 = 0; j2 < cols; j2++) {
        if (j1 == 0 && j2 == cols-1) {
          DP[0][j1][j2] = grid[0][0] + grid[0][cols-1];
        } else {
          DP[0][j1][j2] = -1;
        }
      }
    }

    for (int i = 1; i < rows; i++) {
      for (int j1 = 0; j1 < cols; j1++) {
        for (int j2 = 0; j2 < cols; j2++) {
          int maxDP = -1;
          for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
              if (j1+d1 >= 0 && j1+d1<cols && j2+d2>=0 && j2+d2<cols) {
                if (maxDP == -1 || maxDP < DP[i-1][j1+d1][j2+d2]) {
                  maxDP = DP[i-1][j1+d1][j2+d2];
                }
              }
            }
          }
          int delta = 0;
          if (j1 == j2) {
            delta = grid[i][j1];
          } else {
            delta = grid[i][j1] + grid[i][j2];
          }

          if (maxDP == -1) {
            DP[i][j1][j2] = -1;
          } else {
            DP[i][j1][j2] = maxDP + delta;
          }
        }
      }
    }

    int result = -1;
    for (int j1 = 0; j1 < cols; j1++) {
      for (int j2 = 0; j2 < cols; j2++) {
        if (result == -1 || result < DP[rows-1][j1][j2]) {
          result = DP[rows-1][j1][j2];
        }
      }
    }
    return result;
  }
}
