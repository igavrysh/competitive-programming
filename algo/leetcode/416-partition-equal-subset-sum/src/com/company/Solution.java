package com.company;

public class Solution {

  public static int EMPTY = -1;

  public boolean canPartition(int[] nums) {
    int totalSum = 0;
    for (int i = 0; i < nums.length; i++) {
      totalSum += nums[i];
    }

    if (totalSum % 2 != 0) {
      return false;
    }

    int sumToBuild = totalSum / 2;
    return buildSum(nums, sumToBuild);
  }

  private boolean buildSum(int nums[], int sumToBuild) {
    if (sumToBuild == 0) {
      return true;
    }

    if (sumToBuild < 0) {
      return false;
    }
    boolean result = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != EMPTY) {
        int num_i = nums[i];
        nums[i] = EMPTY;

        boolean output = buildSum(nums, sumToBuild - num_i);

        if (!output) {
          output = buildSum(nums, sumToBuild);
        } else {
          nums[i] = num_i;
          return true;
        }

        if (output) {
          result = output;
        }

        nums[i] = num_i;
      }
    }

    return result;
  }
}
