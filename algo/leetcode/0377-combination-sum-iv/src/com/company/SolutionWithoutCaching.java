package com.company;

/**
 * This solution is not passing  memory / runtime limit exceeded test
 */
public class SolutionWithoutCaching {
  public int combinationSum4(int[] nums, int target) {
    return BT(nums, target);
  }

  private int BT(int [] nums, int target) {
    if (target == 0) {
      return 1;
    }
    if (target < 0) {
      return 0;
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        res += 1;
      } else if (nums[i] < target) {
        res += BT(nums, target - nums[i]);
      }
    }
    return res;
  }
}
