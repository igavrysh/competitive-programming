package com.company;

public class Solution {
  public int integerBreak(int n) {
    if (n==2) {
      return 1;
    }
    if (n==3) {
      return 2;
    }

    int countThrees = n / 3;
    int countTwoes = 0;
    int remainder = n % 3;
    if (remainder == 1) {
      countTwoes = 2;
      countThrees -= 1;
    } else if (remainder == 2) {
      countTwoes = 1;
    }

    return (int)(Math.pow(2, countTwoes) * Math.pow(3, countThrees));
  }
}
