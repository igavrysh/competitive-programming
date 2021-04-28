package com.company;

public class Solution {
  public void rotate(int[][] matrix) {
    int e = matrix.length - 1;
    int s = 0;
    while (e>s) {
      for (int r = 0; r < e-s; r++) {
        int tmp = 0;
        int previous = 0;
        for (int i = 0; i < 4; i++) {
          int currI = 0, currJ = 0;
          int nextI = 0, nextJ = 0;
          if (i == 0) {
            currI = s;
            currJ = s+ r;
            nextI = s+r;
            nextJ = e;
          }
          if (i == 1) {
            currI = s+r;;
            currJ = e;
            nextI = e;
            nextJ = s+ (e-s-r);
          }
          if (i == 2) {
            currI = e;
            currJ = e - (e-s-r);
            nextI = s + (e-s -r);
            nextJ = s;
          }
          if (i == 3) {
            currI = s+(e-s-r);
            currJ = s;
            nextI = s;
            nextJ = s+r;
          }
          if (i == 0) {
            previous = matrix[nextI][nextJ];
            matrix[nextI][nextJ] = matrix[currI][currJ];
          } else {
            tmp = matrix[nextI][nextJ];
            matrix[nextI][nextJ] = previous;
            previous = tmp;
          }
        }
      }
      s += 1;
      e -= 1;
    }
  }
}
