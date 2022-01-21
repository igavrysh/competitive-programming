package com.company;

public class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int min = 1, max = 1;
    for (int i = 0; i < piles.length; i++) {
      if (max < piles[i]) {
        max = piles[i];
      }
    }
    int lK = min;
    int rK = max;
    int currH = 0;

    int mK = lK+(rK-lK)/2;
    while (lK < rK) {
      mK = lK+(rK-lK)/2;
      currH = 0;
      for (int i = 0; i < piles.length; i++) {
        currH += piles[i] / mK + (piles[i] % mK == 0 ? 0 : 1);
      }
      if (currH > h) {
        lK = mK + 1;
      } else if (currH <= h) {
        rK = mK;
      }
    }
    return lK;
  }


}
