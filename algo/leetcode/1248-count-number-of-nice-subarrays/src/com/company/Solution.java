package com.company;

public class Solution {

  public int numberOfSubarrays(int[] nums, int k) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 1) {
        nums[i] = 1;
      } else {
        nums[i] = 0;
      }
    }

    int l = 0;
    int r = 0;
    int sum = nums[r];
    int output = 0;

    while (r < nums.length) {
      if (sum < k) {
        r++;
        if (r < nums.length) {
          sum += nums[r];
        }
      } else if (sum >= k) {
        if (sum == k) {
          output++;
        }
        sum -= nums[l];
        l++;
      }
    }
    return output;
  }

}
