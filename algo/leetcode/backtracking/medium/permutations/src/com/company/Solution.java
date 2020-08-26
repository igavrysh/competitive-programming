package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<Integer> numsList
        = Arrays.stream(nums).boxed().collect(Collectors.toList());
    List<List<Integer>> output = new ArrayList<>();
    permuteInternal(numsList, new ArrayList<>(), output);
    return output;
  }

  private void permuteInternal(
      List<Integer> nums,
      List<Integer> acc,
      List<List<Integer>> output
  ) {
    if (nums.size() == 0) {
      output.add(new ArrayList<>(acc));
    }

    for (int i = 0; i < nums.size(); i++) {
      Integer el = nums.get(i);
      acc.add(el);
      nums.remove(i);
      permuteInternal(nums, acc, output);
      nums.add(i, el);
      acc.remove(acc.size()-1);
    }
  }
}
