package com.company;

import java.util.*;

public class SolutionWithStartIndex {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    subsetsInternal(nums, new ArrayList<>(), output, 0);
    return output;
  }

  private void subsetsInternal(
      int[] nums,
      List<Integer> partialResult,
      List<List<Integer>> output,
      int startIndex) {
    output.add(new ArrayList<>(partialResult));

    for (int i = startIndex; i < nums.length; i++) {
      partialResult.add(nums[i]);
      subsetsInternal(nums, partialResult, output, i + 1);
      partialResult.remove(partialResult.size() - 1);
    }
  }
}
