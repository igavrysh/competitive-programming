package com.company;

import java.util.Arrays;

public class Solution {
  public int threeSumClosest(int[] nums, int target) {
    if (nums.length < 3) {
      return -1;
    }

    Arrays.sort(nums);

    int gOptimal = nums[0] + nums[1] + nums[2];
    for (int idx = 2; idx < nums.length; idx++) {
      int i = 0;
      int j = idx-1;
      int lOptimal = nums[i] + nums[j] + nums[idx];
      while (i < j) {
        if (Math.abs(nums[i] + nums[j] + nums[idx] - target) < Math.abs(lOptimal - target)) {
          lOptimal = nums[i] + nums[j] + nums[idx];
        }
        if (nums[i] + nums[j] + nums[idx] < target) {
          i++;
        } else {
          j--;
        }
      }

      if (Math.abs(lOptimal - target) < Math.abs(gOptimal - target)) {
        gOptimal = lOptimal;
      }
    }
    return gOptimal;
  }
}
