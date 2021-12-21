package com.company;

public class Solution {
  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    int counter = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (isConnected[i][j] != 0 && isConnected[i][j] != -1) {
          counter++;
          dfs(i, j, isConnected, n);
        }
      }
    }
    return counter;
  }

  private void dfs(int i, int j, int[][] isConnected, int n) {
    isConnected[i][j] = -1;
    isConnected[j][i] = -1;
    for (int t = 0; t < n; t++) {
      if (t != i) {
        if (isConnected[t][j] == 1) {
          dfs(t, j, isConnected, n);
        }
      }
      if (t != j) {
        if (isConnected[i][t] == 1) {
          dfs(i, t, isConnected, n);
        }
      }
    }
  }
}
