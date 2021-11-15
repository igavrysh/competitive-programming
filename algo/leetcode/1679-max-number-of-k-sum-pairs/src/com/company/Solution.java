package com.company;

import java.util.Arrays;

public class Solution {
  public int maxOperations(int[] nums, int k) {
    Arrays.sort(nums);
    int l = 0;
    int r = nums.length - 1;
    int result = 0;
    while (l < r) {
      if (nums[l] + nums[r] == k) {
        result++;
        l++;
        r--;
      } else if (nums[l] + nums[r] < k) {
        l++;
      } else {
        r--;
      }
    }
    return result;
  }
}
