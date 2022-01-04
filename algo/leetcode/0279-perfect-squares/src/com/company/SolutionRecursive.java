package com.company;

public class SolutionRecursive {

  public int numSquares(int n) {
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
    return minSq;
  }
}
