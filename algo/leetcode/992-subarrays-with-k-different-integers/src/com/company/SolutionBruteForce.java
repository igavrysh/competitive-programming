package com.company;

import java.util.HashSet;

public class SolutionBruteForce {
  public int subarraysWithKDistinct(int[] nums, int k) {
    int output = 0;
    for (int l = 0; l < nums.length; l++) {
      for (int r = l; r < nums.length; r++) {
        output += isGoodArray(l, r, k, nums) ? 1 : 0;
      }
    }
    return output;
  }

  private boolean isGoodArray(int l, int r, int k, int[] nums) {
    HashSet<Integer> seen = new HashSet<>();
    for (int i = l; i <= r; i++) {
      if (!seen.contains(nums[i])) {
        seen.add(nums[i]);
      }
      if (seen.size() > k) {
        return false;
      }
    }
    return seen.size() == k;
  }
}
