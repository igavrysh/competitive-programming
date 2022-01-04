package com.company;

public class Solution {
  public int uniquePaths(int m, int n) {
    int[][] cache = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        cache[i][j] = -1;
      }
    }
    return findPaths(0, 0, m, n, cache);
  }

  private int findPaths(int i, int j, int m, int n, int[][] cache) {
    if (cache[i][j] != -1) {
      return cache[i][j];
    }

    if (i == m-1 && j == n-1) {
      cache[m-1][n-1] = 1;
      return 1;
    }
    int c1 = 0;
    if (i + 1 < m) {
      c1 = findPaths(i+1, j, m, n, cache);
    }

    int c2 = 0;
    if (j + 1 < n) {
      c2 = findPaths(i, j+1, m, n, cache);
    }

    cache[i][j] = c1 + c2;

    return c1 + c2;
  }
}
