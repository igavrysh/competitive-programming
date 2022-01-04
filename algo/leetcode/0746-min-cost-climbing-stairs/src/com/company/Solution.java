package com.company;

public class Solution {
  public int minCostClimbingStairs(int[] cost) {
    if (cost.length <= 1) {
      return 0;
    }

    int[] DP = new int[cost.length];
    DP[0] = cost[0];
    DP[1] = cost[1];
    for (int i = 2; i<cost.length; i++) {
      DP[i] = cost[i] + Math.min(DP[i-1], DP[i-2]);
    }

    return Math.min(DP[DP.length-1], DP[DP.length-2]);
  }
}
