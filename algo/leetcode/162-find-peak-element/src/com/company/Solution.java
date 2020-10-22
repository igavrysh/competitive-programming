package com.company;

public class Solution {
  public int findPeakElement(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    int l = 0;
    int r = nums.length-1;
    int middlePoint = -1;
    while (l <= r) {
      middlePoint = (l+r)/2;
      long mpValue = nums[middlePoint];
      long lpValue = middlePoint-1 >= 0 ? nums[middlePoint-1] : Long.MIN_VALUE;
      long rpValue = middlePoint+1 < nums.length ? nums[middlePoint+1] : Long.MIN_VALUE;
      if (lpValue >= mpValue) {
        r = middlePoint-1;
      } else if (rpValue >= mpValue) {
        l = middlePoint+1;
      } else {
        return middlePoint;
      }
    }
    return middlePoint;
  }
}
