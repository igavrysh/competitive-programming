package com.company;


class NumArray {

  private int[] cumulative;

  public NumArray(int[] nums) {
    cumulative = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        cumulative[i] = nums[i];
      } else {
        cumulative[i] = nums[i] + cumulative[i - 1];
      }
    }
  }

  public int sumRange(int i, int j) {
    int output = cumulative[j];
    if (i > 0) {
      output -= cumulative[i - 1];
    }
    return output;
  }
}

