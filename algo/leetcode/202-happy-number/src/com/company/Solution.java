package com.company;

public class Solution {
  public boolean isHappy(int n) {
    int iterations = 0;
    int output = n;
    while (output != 1 && iterations < 1000) {
      output = squareOfDigits(output);
      if (output == 1) {
        return true;
      }
      iterations += 1;
    }
    if (output == 1) {
      return true;
    }
    return false;
  }

  private int squareOfDigits(int n) {
    int result = 0;
    int currN = n;
    while (currN != 0) {
      int digit = currN % 10;
      result += Math.pow(digit, 2);
      currN = currN / 10;
    }
    return result;
  }
}
