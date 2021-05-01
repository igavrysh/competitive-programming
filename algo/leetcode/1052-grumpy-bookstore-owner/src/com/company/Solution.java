package com.company;

public class Solution {

  public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    int currCust = 0;
    for (int i = 0; i < customers.length; i++) {
      if (grumpy[i] == 0 || i < X) {
        currCust += customers[i];
      }
    }
    int maxCust = currCust;
    if (X > 0) {
      for (int i = X; i < customers.length; i++) {
        int grumpySub = grumpy[i-X] == 1 ? customers[i-X] : 0;
        int grumpyAdd = grumpy[i] == 1 ? customers[i] : 0;
        currCust = currCust - grumpySub + grumpyAdd;
        if (currCust > maxCust) {
          maxCust = currCust;
        }
      }
    }
    return maxCust;
  }
}
