package com.company;

public class Solution {
  public int minCost(int[][] costs) {
    int N = costs.length;
    int [][] DP = new int[N][3];
    DP[0] = costs[0];
    for (int i = 1; i < N; i++) {
      DP[i][0] = Math.min(DP[i-1][1]+costs[i][0], DP[i-1][2]+costs[i][0]);
      DP[i][1] = Math.min(DP[i-1][0]+costs[i][1], DP[i-1][2]+costs[i][1]);
      DP[i][2] = Math.min(DP[i-1][0]+costs[i][2], DP[i-1][1]+costs[i][2]);
    }
    return Math.min(Math.min(DP[N-1][0], DP[N-1][1]), DP[N-1][2]);
  }
}
