package com.company;

public class Solution {
  public int[] getSumAbsoluteDifferences(int[] nums) {
    int totalSum = 0;
    int N = nums.length;
    for (int i = 0; i < N; i++) {
      totalSum += nums[i];
    }
    int[] result = new int[N];
    int lSum = 0;
    int rSum = totalSum;
    for (int i = 0; i < N; i++) {
      rSum -= nums[i];
      result[i] = i * nums[i] - lSum + rSum - (N - i - 1) * nums[i];
      lSum += nums[i];
    }
    return result;
  }
}
