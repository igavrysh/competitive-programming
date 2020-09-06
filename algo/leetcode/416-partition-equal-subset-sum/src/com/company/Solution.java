package com.company;

public class Solution {

  public boolean canPartition(int[] nums) {
    int totalSum = 0;
    for (int i = 0; i < nums.length; i++) {
      totalSum += nums[i];
    }

    if (totalSum % 2 != 0) {
      return false;
    }

    Boolean[][] freq = new Boolean[totalSum + 1][nums.length + 1];

    return canPartition(nums, 0, totalSum, 0, freq);
  }

  private boolean canPartition(int nums[], int index, int target, int currentSum, Boolean[][] freq) {
    if (2 * currentSum == target) {
      return true;
    }

    if (index >= nums.length || currentSum * 2 > target) {
      return false;
    }

    if (freq[currentSum][index] != null) {
      return freq[currentSum][index];
    }

    boolean lhs = canPartition(nums, index + 1, target, currentSum + nums[index], freq);
    freq[currentSum + nums[index]][index + 1] = lhs;
    if (lhs == true) {
      return lhs;
    }

    boolean rhs = canPartition(nums, index + 1, target, currentSum, freq);
    freq[currentSum][index + 1] = rhs;
    if (rhs == true) {
      return rhs;
    }

    return false;
  }
}
