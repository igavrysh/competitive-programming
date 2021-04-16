package com.company;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class SolutionRecursive {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> output = new ArrayList<>();
    comb(candidates, target, 0, 0, new ArrayList<>(), output, target);
    return output;
  }

  private void comb(int[] candidates, int trg, int startIndex, int accSum, List<Integer> acc,
                    List<List<Integer>> output, int initTrg) {
    if (trg == 0) {
      output.add(new ArrayList<>(acc));
      return;
    }

    if (trg < 0 || startIndex >= candidates.length || trg < candidates[startIndex] || accSum >= initTrg) {
      return;
    }

    for (int i = startIndex; i < candidates.length; i++) {
      if (i != startIndex && i-1>=0 && candidates[i] == candidates[i-1]) {
        continue;
      }
      acc.add(candidates[i]);
      comb(candidates, trg - candidates[i], i+1, accSum + candidates[i], acc, output, initTrg);
      acc.remove(acc.size() - 1);
    }
  }
}
