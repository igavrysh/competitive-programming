package com.company;

public class Solution {

  public int divide(int dividend, int divisor) {
    long dividentTmp = dividend < 0 ? (0 - (long)dividend) : dividend;
    long divisorTmp = divisor < 0 ? (0 - (long)divisor) : divisor;
    long remainder = dividentTmp;
    long counter = 0;
    while (remainder >= 0) {
      remainder = remainder - divisorTmp;
      counter++;
    }
    counter-=1;

    long result = 0;
    if ((dividend < 0 && divisor > 0)
      || (dividend > 0 && divisor < 0)
    ) {
      result = 0 - counter;
    } else {
      result = counter;
    }

    if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    return (int)result;
  }
}
