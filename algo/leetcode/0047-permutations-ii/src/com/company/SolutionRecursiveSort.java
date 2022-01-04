package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionRecursiveSort {

  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> output = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    backtrack(used, nums, new ArrayList<>(), output);
    return output;
  }

  private void backtrack(boolean[] used, int[] nums, List<Integer> acc, List<List<Integer>> output)  {
    if (acc.size() == nums.length) {
      output.add(new ArrayList<>(acc));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i] == false
          && (i == 0 ||  (i > 0 && (nums[i] != nums[i-1] || used[i-1] == true)))) {
        used[i] = true;
        acc.add(nums[i]);
        backtrack(used, nums, acc, output);
        acc.remove(acc.size()-1);
        used[i] = false;
      }
    }
  }
}
