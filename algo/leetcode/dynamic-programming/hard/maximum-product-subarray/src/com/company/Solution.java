package com.company;

public class Solution {
  public int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[] min = new int[nums.length];
    int[] max = new int[nums.length];
    min[0] = nums[0];
    max[0] = nums[0];

    int gMax = nums[0];
    for (int i = 1; i < nums.length; i++) {
      max[i] = Math.max(Math.max(min[i-1] * nums[i], max[i-1] * nums[i]), nums[i]);
      min[i] = Math.min(Math.min(min[i-1] * nums[i], max[i-1] * nums[i]), nums[i]);
      if (gMax < max[i]) {
        gMax = max[i];
      }
    }
    return gMax;
  }
}
