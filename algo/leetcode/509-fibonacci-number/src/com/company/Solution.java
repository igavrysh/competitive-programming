package com.company;

public class Solution {
  public int fib(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int prev = 0;
    int curr = 1;
    int currN = 1;

    while (currN != n) {
      int newnumb = prev + curr;
      prev = curr;
      curr = newnumb;
      currN++;
    }
    return curr;
  }
}
