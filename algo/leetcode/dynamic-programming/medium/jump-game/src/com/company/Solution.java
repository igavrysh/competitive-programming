package com.company;

public class Solution {

  public boolean canJump(int[] nums) {
    int maxReached = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (i > maxReached) {
        return false;
      }

      if (i + nums[i] > maxReached) {
        maxReached = i + nums[i];
      }
    }

    return maxReached >= nums.length - 1;
  }
}

