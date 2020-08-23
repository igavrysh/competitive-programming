package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    output.add(Arrays.asList(new Integer[]{}));
    Set<Integer> numsSet = new HashSet<Integer>(
        IntStream.of(nums).boxed().collect(Collectors.toList())
    );
    subsetsInternal(numsSet, new ArrayList<>(), output);
    return output;
  }

  private void subsetsInternal(
      Set<Integer> nums,
      List<Integer> partialResult,
      List<List<Integer>> output) {
    for (Integer num : nums) {
      if (partialResult.size() == 0 ||
        partialResult.get(partialResult.size() - 1) < num
      ) {
        List<Integer> newSet = new ArrayList<>(partialResult);
        newSet.add(num);
        output.add(newSet);
        Set<Integer> newNums = new HashSet<>(nums);
        newNums.remove(num);
        subsetsInternal(newNums, newSet, output);
      }
    }
  }
}
