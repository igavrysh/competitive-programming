package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionArray {
  public int combinationSum4(int[] nums, int target) {
    Integer[] cache = new Integer[1001];
    for (int i = 0; i <= 1000; i++) {
      cache[i] = -1;
    }
    return BT(nums, target, cache);
  }

  private int BT(int [] nums, int target, Integer[] cache) {
    Integer c = cache[target];
    if (c != -1) {
      return c;
    }

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
        res += BT(nums, target - nums[i], cache);
      }
    }
    cache[target] = res;
    return res;
  }
}