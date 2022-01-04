package com.company;

import java.util.ArrayList;

public class SolutionIntReversal {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    int revese = 0;
    int t = x;
    while (t != 0) {
      revese = revese * 10 + t % 10;
      t /= 10;
    }

    return x == revese;
  }

}
