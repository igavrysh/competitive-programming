package com.company;

import java.util.HashSet;

public class SolutionOptimized {
  public class Solution {
    public boolean isHappy(int n) {
      HashSet<Integer> occurances = new HashSet<>();
      int output = n;
      while (output != 1) {
        output = squareOfDigits(output);
        if (output == 1) {
          return true;
        }
        if(occurances.contains(output)) {
          return false;
        }
        occurances.add(output);
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

}
