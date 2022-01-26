package com.company;

import java.util.Arrays;

public class SolutionDP {
  public int maximalRectangle(char[][] matrix) {
    int N = matrix.length;
    int M = matrix[0].length;
    int[] h = new int[M], l = new int[M], r = new int[M];
    Arrays.fill(r, M);
    Arrays.fill(l, -1);
    int res = 0;
    for (int i = 0; i < N; i++) {
      int currLeft = -1;
      int currRight = M;
      int[] hloc = new int[M], lloc = new int[M], rloc = new int[M];

      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == '1') {
          hloc[j] = h[j] + 1;
        } else {
          hloc[j] = 0;
        }
      }

      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == '1') {
          if (currLeft == -1) {
            currLeft = j;
          }
        } else {
          l[j] = -1;
          currLeft = -1;
        }
        lloc[j] = Math.max(currLeft, l[j]);
      }

      for (int j = M-1; j >= 0; j--) {
        if (matrix[i][j] == '1') {
          if (currRight == M) {
            currRight = j;
          }
        } else {
          r[j] = M;
          currRight = M;
        }
        rloc[j] = Math.min(currRight, r[j]);
      }

      h = hloc;
      r = rloc;
      l = lloc;
      for (int j = 0; j < M; j++) {
        if (r[j] != M && l[j] != -1 && h[j] > 0) {
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
