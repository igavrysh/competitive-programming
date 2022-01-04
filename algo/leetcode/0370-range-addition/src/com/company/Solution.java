package com.company;

public class Solution {

  public int[] getModifiedArray(int length, int[][] updates) {
    int[] acc = new int[length];
    for (int i = 0; i < length; i++) {
      acc[i] = 0;
    }
    for (int i = 0; i < updates.length; i++) {
      acc[updates[i][0]] += updates[i][2];
      if (updates[i][1]+1 < length) {
        acc[updates[i][1]+1] -= updates[i][2];
      }
    }
    int[] output = new int[length];
    for (int i = 0; i < length; i++) {
      if (i > 0) {
        output[i] = output[i-1] + acc[i];
      } else {
        output[i] = acc[i];
      }
    }
    return output;
  }

}
