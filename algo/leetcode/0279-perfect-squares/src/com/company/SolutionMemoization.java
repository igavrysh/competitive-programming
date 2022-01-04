package com.company;

public class SolutionMemoization {
  public int numSquares(int n) {
    int[] cache = new int[n+1];
    for (int i = 0; i < cache.length; i++) {
      cache[i] = -1;
    }
    int output = num(n, cache);
    return output;
  }

  private int num(int n, int[] cache) {
    if (cache[n] != -1) {
      return cache[n];
    }

    if (n == 0) {
      return 0;
    }
    if (n < 0) {
      return Integer.MAX_VALUE;
    }

    int maxComp = (int)Math.sqrt(n);

    int minSq = Integer.MAX_VALUE;
    for (int i = 1; i <= maxComp; i++) {
      int s = numSquares(n - i*i);
      if (s != Integer.MAX_VALUE && minSq > s) {
        minSq = 1 + s;
      }
    }

    cache[n] = minSq;

    return minSq;
  }
}
