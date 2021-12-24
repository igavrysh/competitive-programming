package com.company;

import java.util.Arrays;

public class Solution {
  public int maximumUnits(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, (int[] ub1, int[]ub2) -> {
      return ub2[1] - ub1[1];
    });

    int accBoxes = 0;
    int accUnits = 0;
    int i = 0;
    while (accBoxes < truckSize && i < boxTypes.length) {
      accUnits += Math.min(truckSize - accBoxes, boxTypes[i][0]) * boxTypes[i][1];
      accBoxes += Math.min(truckSize - accBoxes, boxTypes[i][0]);
      i++;
    }
    return accUnits;
  }

}
