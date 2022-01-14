package com.company;

public class Solution2 {

  public int minOperations(int[] nums, int x) {
    int totalSum = 0;
    for (int i = 0; i < nums.length; i++) {
      totalSum += nums[i];
    }
    if (totalSum < x) {
      return -1;
    }
    if (totalSum == x) {
      return nums.length;
    }

    int targetSum = totalSum - x;
    int l = 0, r = 0, currSum = nums[l], maxLength = -1;
    while (r < nums.length) {
      if (currSum < targetSum) {
        r = r+1;
        if (r < nums.length) {
          currSum += nums[r];
        }
      } else if (currSum > targetSum) {
        currSum -= nums[l];
        l = l+1;
      } else {
        if (maxLength < r-l+1) {
          maxLength = r-l+1;
        }
        r = r+1;
        if (r < nums.length) {
          currSum += nums[r];

        }
      }
    }
    return maxLength != -1 ? nums.length - maxLength : -1;
  }
}
