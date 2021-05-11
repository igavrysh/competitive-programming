package com.company;

public class Solution2 {

  public int[][] generateMatrix(int n) {
    int counter = 1;
    int[][] output = new int[n][n];
    for (int l = 0; l < n/2 + n%2; l++) {
      for (int j = l; j < n-l; j++) {
        output[l][j] = counter++;
      }
      for (int i = l+1; i < n-l; i++) {
        output[i][n-1-l] = counter++;
      }
      for (int j = n-1-l-1; j >= l; j--) {
        output[n-1-l][j] = counter++;
      }
      for (int i = n-1-l-1; i >= l+1; i--) {
        output[i][l] = counter++;
      }
    }
    return output;
  }
}
