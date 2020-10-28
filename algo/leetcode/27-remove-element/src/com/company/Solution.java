package com.company;

public class Solution {
  public int removeElement(int[] nums, int val) {
    int internalIndex = 0;
    int lenth = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[internalIndex] = nums[i];
        internalIndex++;
        lenth++;
      }
    }
    return lenth;
  }
}

