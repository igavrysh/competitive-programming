package com.company;

public class SolutionOptimized {

  public int minCostClimbingStairs(int[] cost) {
    if (cost.length <= 1) {
      return 0;
    }

    int prevPrev = cost[0];
    int prev = cost[1];
    int current = 0;
    for (int i = 2; i < cost.length; i++) {
      current = cost[i] + Math.min(prev, prevPrev);
      prevPrev = prev;
      prev = current;
    }

    return Math.min(prevPrev, prev);
  }
}