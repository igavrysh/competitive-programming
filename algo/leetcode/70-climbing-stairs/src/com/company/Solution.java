package com.company;

public class Solution {
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    int currN = 3;
    int prevVal = 2;
    int prevPrevVal = 1;
    while (currN <= n) {
      int tmp = prevPrevVal;
      prevPrevVal = prevVal;
      prevVal = tmp + prevVal;
      currN += 1;
    }
    return prevVal;
  }
}
