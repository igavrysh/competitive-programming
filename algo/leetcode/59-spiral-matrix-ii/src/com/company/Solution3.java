package com.company;

public class Solution3 {
  public int[][] generateMatrix(int n) {
    int[][] D = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    int counter = 1;
    int d = 0;
    int i = 0;
    int j = 0;
    int[][] output = new int[n][n];
    while (counter <= n*n) {
      output[i][j] = counter++;
      if (i + D[d][0] < 0
          || i + D[d][0] >= n
          || j + D[d][1] < 0
          || j + D[d][1] >= n
          || output[i + D[d][0]][j + D[d][1]] != 0) {
        d = (d + 1) % 4;
      }
      i = i + D[d][0];
      j = j + D[d][1];
    }
    return output;
  }
}
