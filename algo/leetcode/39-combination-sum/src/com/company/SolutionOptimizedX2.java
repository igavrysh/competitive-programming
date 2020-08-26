package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionOptimizedX2 {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> output = new ArrayList<>();
    combinationSumInternal(candidates, target, 0, 0, new ArrayList<>(), output, target);
    return output;
  }

  public void combinationSumInternal(
      int[] candidates,
      int target,
      int startIndex,
      int accSum,
      List<Integer> acc,
      List<List<Integer>> output,
      int initialTarget
  ) {
    if (target == 0) {
      output.add(new ArrayList<>(acc));
      return;
    }

    if (target < 0) {
      return;
    }

    if (target < candidates[startIndex]) {
      return;
    }

    if (accSum >= initialTarget) {
      return;
    }

    for (int i = startIndex; i < candidates.length; i++) {
      acc.add(candidates[i]);
      combinationSumInternal(candidates, target - candidates[i], i, accSum + candidates[i], acc, output, initialTarget);
      acc.remove(acc.size() - 1);
    }
  }
}
