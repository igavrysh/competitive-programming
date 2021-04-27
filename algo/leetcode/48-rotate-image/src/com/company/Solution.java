package com.company;

public class Solution {
  public void rotate(int[][] matrix) {
    int N = matrix.length;
    int s = 0;
    while (N != 0 && N != 1) {
      int S = (N - 1) * 4;
      for (int r = 0; r < N - 1; r++) {
        int tmp = 0;
        int previous = 0;
        for (int i = 0; i < 4; i++) {
          int[] currIJ = new int[2];
          int[] nextIJ = new int[2];
          if (i == 0) {
            currIJ[0] = s;
            currIJ[1] = r;
            nextIJ[0] = r % N;
            nextIJ[1] = N - 1;
          }
          if (i == 1) {
            currIJ[0] = r % N;
            currIJ[1] = N - 1;
            nextIJ[0] = N - 1;
            nextIJ[1] = N - 1 - r % N;
          }
          if (i == 2) {
            currIJ[0] = N - 1;
            currIJ[1] = N - 1 - r % N;
            nextIJ[0] = N - 1 - r % N;
            nextIJ[1] = s;
          }
          if (i == 3) {
            currIJ[0] = N - 1 - r % N;
            currIJ[1] = s;
            nextIJ[0] = s;
            nextIJ[1] = r;
          }
          if (i == 0) {
            previous = matrix[nextIJ[0]][nextIJ[1]];
            matrix[nextIJ[0]][nextIJ[1]] = matrix[currIJ[0]][currIJ[1]];
          } else {
            tmp = matrix[nextIJ[0]][nextIJ[1]];
            matrix[nextIJ[0]][nextIJ[1]] = previous;
            previous = tmp;
          }
        }
      }
      s += 1;
      N -= 2;
    }

  }
}
