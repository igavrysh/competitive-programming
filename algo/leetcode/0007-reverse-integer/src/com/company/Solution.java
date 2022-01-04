package com.company;

import java.util.Stack;

public class Solution {
  public int reverse(int x) {
    int remainder = x;
    int result = 0;
    while (remainder != 0) {
      int pop = remainder % 10;
      remainder /= 10;
      int prevResult = result;
      result = result * 10;
      if (prevResult != 0 && result / prevResult != 10) {
        return 0;
      }
      result += pop;
    }
    return result;
  }
}
