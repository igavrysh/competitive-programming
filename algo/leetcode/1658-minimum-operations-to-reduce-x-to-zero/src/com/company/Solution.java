package com.company;

public class Solution {
  public int minOperations(int[] nums, int x) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    int targetSum = sum - x;
    if (targetSum == 0) {
      return nums.length;
    }
    int l = 0;
    int r = -1;
    int size = 0;
    int currSum = 0;
    int maxLength = 0;
    while (r < nums.length) {
      if (currSum > targetSum && l < r) {
        currSum -= nums[l];
        l++;
        size--;
      } else {
        r++;
        if (r < nums.length) {
          currSum += nums[r];
          size++;
        }
      }
      if (currSum == targetSum) {
        if (maxLength < size) {
          maxLength = size;
        }
      }
    }
    if (maxLength == 0) {
      return -1;
    }
    return nums.length - maxLength;
  }
}
