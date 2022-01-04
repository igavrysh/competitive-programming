package com.company;

public class SolutionFreqArray {
  public int firstMissingPositive(int[] nums) {
    int[] fq = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0 && nums[i]-1 < fq.length) {
        fq[nums[i]-1] = fq[nums[i]-1] + 1;
      }
    }
    for (int i = 0; i < fq.length; i++) {
      if (fq[i] == 0) {
        return i+1;
      }
    }
    return fq.length+1;
  }
}
