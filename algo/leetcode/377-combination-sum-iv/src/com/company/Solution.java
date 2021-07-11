package com.company;

import java.util.HashMap;

public class Solution {
  public int combinationSum4(int[] nums, int target) {
    return BT(nums, target, new HashMap<Integer, Integer>());
  }

  private int BT(int [] nums, int target, HashMap<Integer, Integer> cache) {
    Integer c = cache.get(target);
    if (c != null) {
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
    cache.put(target, res);
    return res;
  }
}
