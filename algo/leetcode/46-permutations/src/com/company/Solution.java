package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    return new ArrayList<>b();
  }

  private  List<List<Integer>> permuteInternal(
      Set<Integer> nums,
      int numsRequired,
      ArrayList<Integer> partialResult) {
    if (numsRequired == 0) {
      List<List<Integer>> result = new ArrayList<>();
      result.add(partialResult);
      return result;
    }

    List<List<Integer>> output = new ArrayList<>();

    for (Integer v : nums) {
      Set<Integer> numsToPass = nums.stream()
          .filter(s -> s != v).collect(Collectors.toSet());
      ArrayList<Integer> partialResultToPass = new ArrayList<>();
      partialResultToPass.addAll(partialResult);
      partialResultToPass.add(v);
      output.addAll(
          permuteInternal(
              numsToPass,
              numsRequired - 1,
              partialResultToPass));
    }


    return output;
  }



}
