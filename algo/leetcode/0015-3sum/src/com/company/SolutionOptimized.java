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
    int i = 2;
    while (i < nums.length) {
      if (i+1 < nums.length && nums[i] == nums[i+1]) {
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
          i+=1;
        }
      }
      int l = 0;
      int r = i-1;

      while (l < r) {
        if (nums[i] + nums[l] + nums[r] == 0) {
          output.add(Arrays.asList(new Integer[]{nums[l], nums[r], nums[i]}));
        }

        if ((nums[l] + nums[r]) >= -nums[i]) {
          if (nums[r] == nums[r-1]) {
            while (r - 1 >= 0 && nums[r] == nums[r-1]) {
              r-= 1;
            }
          }
          r--;

        } else if ((nums[l] + nums[r]) < -nums[i]) {
          if (nums[l] == nums[l+1]) {
            while (l+1 <= i-1 && nums[l] == nums[l+1]) {
              l+= 1;
            }
          }
          l++;
        }
      }

      i++;
    }
    return output;
  }
}
