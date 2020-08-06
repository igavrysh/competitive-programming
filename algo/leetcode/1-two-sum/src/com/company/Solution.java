package com.company;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int key = target - nums[i];
      Integer index = map.get(nums[i]);
      if (index == null) {
        map.put(key, i);
      } else {
        return new int[]{index, i};
      }
    }
    return new int[]{};
  }
}