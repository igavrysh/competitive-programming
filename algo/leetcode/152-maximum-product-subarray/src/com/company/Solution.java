package com.company;

public class Solution {

  public int maxProduct(int[] nums) {
    int N = nums.length;
    int[] maxProduct = new int[N];
    int[] minProduct = new int[N];
    maxProduct[0] = nums[0];
    minProduct[0] = nums[0];
    int globalMax = nums[0];

    for (int i = 1; i < nums.length; i++) {
      maxProduct[i] = Math.max(
          Math.max(maxProduct[i - 1] * nums[i], minProduct[i - 1] * nums[i]),
          nums[i]);
      minProduct[i] = Math.min(
          Math.min(maxProduct[i - 1] * nums[i], minProduct[i - 1] * nums[i]),
          nums[i]);
      if (globalMax < maxProduct[i]) {
        globalMax = maxProduct[i];
      }
    }
    return globalMax;
  }
}
