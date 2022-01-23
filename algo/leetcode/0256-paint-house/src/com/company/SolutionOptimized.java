package com.company;

public class SolutionOptimized {
  public int minCost(int[][] costs) {
    int N = costs.length;
    int[] DP = new int[3];
    DP = costs[0];
    for (int i = 1; i < N; i++) {
      int[] newDP = new int[3];
      newDP[0] = Math.min(DP[1]+costs[i][0], DP[2]+costs[i][0]);
      newDP[1] = Math.min(DP[0]+costs[i][1], DP[2]+costs[i][1]);
      newDP[2] = Math.min(DP[0]+costs[i][2], DP[1]+costs[i][2]);
      DP = newDP;
    }
    return Math.min(Math.min(DP[0], DP[1]), DP[2]);
  }
}
