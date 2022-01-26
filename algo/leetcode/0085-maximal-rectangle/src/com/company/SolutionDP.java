package com.company;

import java.util.Arrays;

public class SolutionDP {
  public int maximalRectangle(char[][] matrix) {
    int N = matrix.length;
    int M = matrix[0].length;
    int[] h = new int[M], l = new int[M], r = new int[M];
    int res = 0;
    for (int i = 0; i < N; i++) {
      int currLeft = -1;
      int currRight = Integer.MAX_VALUE;
      int[] hloc = new int[M], lloc = new int[M], rloc = new int[M];
      Arrays.fill(rloc, Integer.MAX_VALUE);

      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == '1') {
          hloc[j] = h[j] + 1;
          if (currLeft == -1) {
            currLeft = j;
          }
        } else {
          hloc[j] = 0;
          currLeft = -1;
        }

        if (i==0) {
          lloc[j] = currLeft;
        } else {
          if (matrix[i][j] == '0') {
            lloc[j] = -1;
          } else {
            lloc[j] = Math.max(currLeft, l[j]);
          }
        }

        if (matrix[i][M-1-j] == '1') {
          hloc[M-1-j] = h[M-1-j] + 1;
          if (currRight == Integer.MAX_VALUE) {
            currRight = M-1-j;
          }
        } else {
          hloc[M-1-j] = 0;
          currRight = Integer.MAX_VALUE;
        }

        if (i==0) {
          rloc[M-1-j] = currRight;
        } else {
          if (matrix[i][M-1-j] == '0') {
            rloc[M-1-j] = Integer.MAX_VALUE;
          } else {
            rloc[M - 1 - j] = Math.min(currRight, r[M - 1 - j]);
          }
        }
      }

      h = hloc;
      r = rloc;
      l = lloc;
      int t = 1;
      for (int j = 0; j < M; j++) {
        if (r[j] != Integer.MAX_VALUE && l[j] != -1 && h[j] > 0) {
          int area = h[j] * (r[j]-l[j]+1);
          if (res < area) {
            res = area;
          }
        }
      }
    }
    return res;
  }
}
