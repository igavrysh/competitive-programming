package com.company;

public class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    int minLength = Integer.MAX_VALUE;
    int currentSum = 0;
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      currentSum += nums[i];

      while (currentSum >= s && i >= j) {
        if (minLength > i-j+1) {
          minLength = i-j+1;
        }
        currentSum -= nums[j];
        j++;
      }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }

}
