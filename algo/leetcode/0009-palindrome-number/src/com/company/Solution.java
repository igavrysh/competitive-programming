package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    List<Integer> digits = new ArrayList<>();
    int t = x;
    while (t != 0) {
      digits.add(t % 10);
      t /= 10;
    }
    int e = digits.size() / 2 - 1;
    for (int i = 0; i <= e; i++) {
      if (digits.get(digits.size() - 1 - i) != digits.get(i)) {
        return false;
      }
    }
    return true;
  }
}
