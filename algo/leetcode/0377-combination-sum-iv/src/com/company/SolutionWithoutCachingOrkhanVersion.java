package com.company;

/**
 * Orkhan Solution, copied it to check if it passes memory / runtime limit exceeded test
 * TLDR; It is not
 */
public class SolutionWithoutCachingOrkhanVersion {
  public int combinationSum4(int[] nums, int target) {
    int result = 0;
    bt(nums, target, result);
    return result;
  }

  private void bt(int[] nums, int target, int result) {
    if (target == 0) {
      result++;
      return;
    } else if (target < 0) {
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      bt(nums, target-nums[i], result);
    }
  }
}
