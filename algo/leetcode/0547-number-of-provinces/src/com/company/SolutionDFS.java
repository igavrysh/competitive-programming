package com.company;

public class SolutionDFS {

  public void dfs(int i, int[] visited, int[][] isConnected) {
    visited[i] = 1;
    for (int j = 0; j < visited.length; j++) {
      if (visited[j] == 0 && isConnected[i][j] == 1) {
        dfs(j, visited, isConnected);
      }
    }
  }

  public int findCircleNum(int[][] isConnected) {
    int[] visited = new int[isConnected.length];
    int counter = 0;
    for (int i = 0; i < visited.length; i++) {
      if (visited[i] == 0) {
        counter++;
        dfs(i, visited, isConnected);
      }
    }
    return counter;
  }

}
