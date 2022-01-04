package com.company;

public class SolutionDP {

  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] left = new int[nums.length];
    int[] right = new int[nums.length];

    int maxLeft = 0;
    int maxRight = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i % k == 0) {
        maxLeft = nums[i];
      } else {
        maxLeft = Math.max(nums[i], maxLeft);
      }
      left[i] = maxLeft;

      int j = nums.length - 1 - i;
      if (j % k == k-1 || j == nums.length-1) {
        maxRight = nums[j];
      } else {
        maxRight = Math.max(nums[j], maxRight);
      }
      right[j] = maxRight;
    }
    int[] output = new int[nums.length - k + 1];
    for (int s = 0; s < output.length; s++) {
      output[s] = Math.max(right[s], left[s + k -1]);
    }
    return output;
  }

}
