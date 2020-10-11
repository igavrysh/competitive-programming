package com.company;

public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int i = 0;
    int j = 1;
    int output = 0;

    while (j < nums.length) {
      if (nums[i] == nums[j]) {
        j++;
      } else {
        nums[i+1] = nums[j];
        i++;
        j++;
        output++;
      }
    }
    return output+1;
  }
}
