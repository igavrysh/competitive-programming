package com.company;

public class SolutionConstantSpace2 {
  public int firstMissingPositive(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= 0 || nums[i] > nums.length) {
        nums[i] = nums.length + 1;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      int pos = Math.abs(nums[i]) - 1;
      if (pos < nums.length && nums[pos] > 0) {
        nums[pos] = -1 * nums[pos];
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        return i+1;
      }
    }
    return nums.length+1;
  }
}
