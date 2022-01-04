package com.company;

import java.util.HashMap;

public class Solution {
  public int subarraysWithKDistinct(int[] nums, int k) {
    return subarraysWithLessOrEqualKDistinct(nums, k)
        - subarraysWithLessOrEqualKDistinct(nums, k-1);
  }

  private int subarraysWithLessOrEqualKDistinct(int[] nums, int k) {
    if (k <= 0) {
      return 0;
    }

    int output = 0;
    HashMap<Integer, Integer> fq = new HashMap<>();
    int l = 0;
    for (int r = 0; r < nums.length; r++) {
      fq.put(nums[r], fq.get(nums[r]) == null ? 1 : fq.get(nums[r])+1);
      while (fq.size() > k && l < r) {
        int numLFq = fq.get(nums[l]);
        if (numLFq == 1) {
          fq.remove(nums[l]);
        } else {
          fq.put(nums[l], numLFq-1);
        }
        l++;
      }
      output += r-l+1;
    }
    return output;
  }
}
