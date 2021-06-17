package com.company;

public class SolutionOptimized {

  public boolean search(int[] nums, int target) {
    int l = 0;
    int r = nums.length-1;
    while (l < r) {
      int m = l+(r-l)/2;
      if (nums[l] == target) {
        return true;
      }
      if (nums[l] <= target) {         // target in First Segment
        if (nums[l] < nums[m]) {           // mid in First Segment
          if (target > nums[m]) {
            l = m+1;
          } else if (target < nums[m]) {
            r = m-1;
          } else if (target == nums[m]) {
            return true;
          }
        } else if (nums[l] > nums[m]) {            // mid in Second Segment
          r = m-1;
        } else if (nums[l] == nums[m]) {           // mid can be in First or Second Segment
          l = l+1;
        }
      } else if (nums[l] > target) {         // target in Second Segment
        if (nums[l] < nums[m]) {             // mid in First Segment
          l = m+1;
        } else if (nums[l] > nums[m]) {    // mid in Second Segment
          if (nums[m] > target) {
            r = m-1;
          } else if (nums[m] < target) {
            l = m+1;
          } else if (nums[m] == target) {
            return true;
          }
        } else if (nums[l] == nums[m]) {   // mid can be in first or second segment
          l = l+1;
        }
      }
    }
    return false;
  }
}
