package com.company;

public class SolutionBSOptimized {
  public int findPeakElement(int[] nums) {
    if (nums.length == 0) {
      return -1;
    }

    int l = 0;
    int r = nums.length-1;
    while (l < r) {
      int mid = (l+r) / 2;
      if (nums[mid] < nums[mid+1]) {
        l = mid+1;
      } else {
        r = mid;
      }
    }
    return l;
  }
}
