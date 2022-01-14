package com.company;

public class Solution {

  public int maximalSquare(char[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] DP = new int[rows][cols];
    int largestSquare = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == '1') {
          int top = i == 0 ? 0 : DP[i-1][j];
          int left = j == 0 ? 0 : DP[i][j-1];
          int topleft = i == 0 || j == 0 ? 0 : DP[i-1][j-1];
          DP[i][j] = Math.min(topleft, Math.min(top, left)) + 1;
          if (DP[i][j] >= largestSquare) {
            largestSquare = DP[i][j];
          }
        }
      }
    }
    return largestSquare*largestSquare;
  }
}
