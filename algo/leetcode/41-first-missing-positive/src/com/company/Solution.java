package com.company;

import java.util.Arrays;

public class Solution {
  public int firstMissingPositive(int[] nums) {
    Arrays.sort(nums);
    int t = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        if (nums[i] != t) {
          return t;
        }
        if (i+1 < nums.length && nums[i] == nums[i+1]) {
        } else {
          t++;
        }
      }
    }
    return t;
  }
}
