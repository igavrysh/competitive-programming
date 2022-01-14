package com.company;

public class Solution {
  public int tribonacci(int n) {
    int t0 = 0;
    int t1 = 1;
    int t2 = 1;
    if (n==0) {
      return t0;
    }
    if (n==1) {
      return t1;
    }
    if (n==2) {
      return t2;
    }
    int currN = 2;
    int t3 = 0;
    while (currN<n) {
      t3 = t2+t1+t0;
      t0 = t1;
      t1 = t2;
      t2 = t3;
      currN++;
    }
    return t3;
  }
}
