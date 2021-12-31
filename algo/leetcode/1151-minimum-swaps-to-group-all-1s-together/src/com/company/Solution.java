package com.company;

public class Solution {
  public int minSwaps(int[] data) {
    int ones = 0;
    for (int d : data) {
      if (d == 1) {
        ones++;
      }
    }
    int numberOfZeroes = 0;
    for (int i = 0; i < ones; i++) {
      if (data[i] == 0) {
        numberOfZeroes++;
      }
    }
    int minSwaps = numberOfZeroes;
    for (int r = ones; r < data.length; r++) {
      if (data[r] == 0) {
        numberOfZeroes++;
      }
      if (data[r-ones] == 0){
        numberOfZeroes--;
      }

      if (numberOfZeroes < minSwaps) {
        minSwaps = numberOfZeroes;
      }
    }
    return minSwaps;
  }
}
