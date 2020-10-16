package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionOptimized {
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length == 0) {
      return new ArrayList<>();
    }

    List<List<Integer>> output = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length-2; i++) {
      int l = i+1;
      int r = nums.length-1;
      while (l<r) {
        if (nums[i] + nums[l] + nums[r] == 0) {
          output.add(Arrays.asList(new Integer[]{nums[l], nums[r], nums[i]}));
        }
        if (l+1 < nums.length && nums[l] == nums[l+1]) {
          l++;
        }
        if (r-1 >= 0 && nums[r] == nums[r-1]) {
          r--;
        }
        l++;
        r--;
      }
    }

    return output;
  }
}
