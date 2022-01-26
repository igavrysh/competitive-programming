package com.company;

import java.util.Stack;

public class SolutionHistogram {
  public int maximalRectangle(char[][] matrix) {
    int N = matrix.length;
    int M = matrix[0].length;
    int[] h = new int[M];
    int res = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == '1') {
          h[j] = h[j]+1;
        } else {
          h[j] = 0;
        }
      }
      Stack<Integer> S = new Stack<>();
      S.push(-1);
      for (int j = 0; j <= M; j++) {
        while (S.peek() != -1 && (j == M || h[S.peek()] > h[j])) {
          int currIndex = S.pop();
          int prevIndex = S.peek();
          int area = h[currIndex] * (j - prevIndex - 1);
          if (area > res) {
            res = area;
          }
        }
        S.push(j);
      }
    }
    return res;
  }
}
