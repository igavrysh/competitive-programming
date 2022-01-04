package com.company;

public class SolutionOptimized2 {
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

    double res = 1;

    while (n != 0) {
      if (n % 2 != 0) {
        res *= x;
      }
      n /= 2;
      x = x * x;
    }
    return res;
  }
}
