package com.company;

public class SolutionInefficient {

  public int climbStairs(int n) {
    int[] calculated = new int[n+1];
    for (int i = 0; i < calculated.length; i++) {
      calculated[i] = -1;
    }
    climbStairsInternal(n, calculated);
    return calculated[n];
  }

  private void climbStairsInternal(int n, int[] calculated) {
    if (n == 0) {
      calculated[0] = 0;
      return;
    }
    if (n == 1) {
      calculated[1] = 1;
      return;
    }
    if (n == 2) {
      calculated[2] = 2;
      return;
    }

    climbStairsInternal(n - 1, calculated);
    climbStairsInternal(n - 2, calculated);

    calculated[n] = calculated[n-1] +calculated[n-2];
  }
}
