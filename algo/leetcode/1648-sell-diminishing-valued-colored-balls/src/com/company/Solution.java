package com.company;

// !!! NOT WORKING - test4 is failng, see Main.java for details and test specifics

public class Solution {
  public int maxProfit(int[] inventory, int orders) {

    int maxValue = 0;
    for (int i : inventory) {
      if (maxValue < i) {
        maxValue = i;
      }
    }

    int l = 1;
    int h = maxValue;
    long m = 1000000007;

    while (l <= h) {
      int k = l + (h-l)/2;
      int currO = 0;
      int kLevCounter = 0;
      for (int i : inventory) {
        currO += Math.max(i - k, 0);
        if (i >= k) {
          kLevCounter++;
        }
      }
      if (orders >= currO && orders <= currO + kLevCounter) {
        long profit = 0;
        for (int i : inventory) {
          long delta =  (long)(i + k+1)*(long)Math.max(i-(k+1)+1, 0) / 2;
          if (delta < 0) {
            throw new RuntimeException("overflow");
          }
          profit += delta %m;
        }
        profit += ((long)(orders - currO)*(long)k)%m;

        return (int)(profit%m);
      } else if (orders < currO) {
        l = k+1;
      } else if (orders > currO + kLevCounter) {
        h = k-1;
      } else {
        throw new RuntimeException("unexpected state reached");
      }
    }
    return -1;
  }
}
