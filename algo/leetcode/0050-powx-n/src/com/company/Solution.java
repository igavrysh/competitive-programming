package com.company;

public class Solution {

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

    double res = 1;
    for (int i = 0; i < Math.abs(n); i++) {
      res *= x;
    }
    return n >= 0 ? res : 1/res;
  }
}
