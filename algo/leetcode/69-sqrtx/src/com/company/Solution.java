package com.company;

public class Solution {
  public int mySqrt(int x) {
    long l = 0;
    long r = x;
    while (l <= r) {
      long m = l + (r - l) / 2;
      long m2 = m * m;
      if (m2 == x
          || (m2 < x
          && ((m+1) * (m+1)) > x)) {
        return (int)m;
      } else {
        if (m2 > x) {
          r = m-1;
        } else {
          l = m+1;
        }
      }
    }
    return -1;
  }
}
