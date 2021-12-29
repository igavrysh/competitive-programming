package com.company;

import java.util.ArrayList;

public class SolutionMath {
  public int kthFactor(int n, int k) {
    ArrayList<Integer> smallDivisors = new ArrayList<>();
    for (int i = 1; i <= Math.sqrt(n); i++) {
      if (n%i == 0) {
        smallDivisors.add(i);
        if (smallDivisors.size() == k) {
          return smallDivisors.get(k-1);
        }
      }
    }
    int s = smallDivisors.size() - (k - smallDivisors.size());
    if (Math.pow(smallDivisors.get(smallDivisors.size()-1), 2) == n) {
      s -= 1;
    }
    if (s >= 0) {
      return n / smallDivisors.get(s);
    }
    return -1;
  }
}
