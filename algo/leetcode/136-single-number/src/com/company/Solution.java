package com.company;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public int singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        set.remove(nums[i]);
      } else {
        set.add(nums[i]);
      }
    }

    if (set.size() == 0) {
      return -9999;
    }

    return (int) set.toArray()[0];
  }
}