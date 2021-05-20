package com.company;

public class Solution2 {
  public void sortColors(int[] nums) {
    int n0 = -1;
    int n1 = -1;
    int n2 = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        n0++;
        n1++;
        n2++;
        nums[n2] = 2;
        nums[n1] = 1;
        nums[n0] = 0;
      } else if (nums[i] == 1) {
        n1++;
        n2++;
        nums[n2] = 2;
        nums[n1] = 1;
      } else if (nums[i] == 2) {
        n2++;
        nums[n2] = 2;
      }
    }
  }
}
