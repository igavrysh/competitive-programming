package com.company;

public class Solution {
  public void sortColors(int[] nums) {
    int[] fq = new int[3];
    for (int i = 0; i < nums.length; i++) {
      fq[nums[i]]++;
    }
    for (int i = 0; i < nums.length; i++) {
      if (i < fq[0]) {
        nums[i] = 0;
      } else if (i < fq[0] + fq[1]) {
        nums[i] = 1;
      } else {
        nums[i] = 2;
      }
    }
  }
}
