package com.company;

public class SolutionOptimized {

  public double myPow(double x, int n) {
    if (n == 0 || x == 1) {
      return 1;
    }
    if (x == -1) {
      return 1 * Math.abs(n) % 2 == 0 ? 1 : -1;
    }

    if (x < 1.0 && x > -1 && n > (Integer.MAX_VALUE / 4)) {
      return 0.0;
    }

    int max = -1000000;
    if (n <= max) {
      return 0.0;
    }

    if (n < 0) {
      return myPow(1/x, -n);
    }

    double res = x;
    int k = 1;
    while (k < n) {
      if (k*2 < n) {
        res *= res;
        k *= 2;
      }
      else {
        res *= x;
        k++;
      }
    }
    return res;
  }
}
