package com.company;

public class Solution {
  public boolean canJump(int[] nums) {
    int maxJamp = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (maxJamp < i + nums[i]) {
        maxJamp = i + nums[i];
      }

      if (maxJamp >= nums.length - 1) {
        return true;
      }

      if (i + 1 > maxJamp) {
        return false;
      }
    }
    return true;
  }

}
