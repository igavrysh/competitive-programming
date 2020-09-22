package com.company;

class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[] seq = new int[nums.length];
    for (int i = 0; i < seq.length; i++) {
      seq[i] = 1;
    }
    for (int i = 1; i < nums.length; i++) {
      int lMax = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j] && lMax < seq[j]+1) {
          lMax = seq[j] + 1;
        }
      }
      seq[i] = lMax;
    }
    int output = seq[0];
    for (int i = 0; i < seq.length; i++) {
      if (output < seq[i]) {
        output = seq[i];
      }
    }
    return output;
  }
}