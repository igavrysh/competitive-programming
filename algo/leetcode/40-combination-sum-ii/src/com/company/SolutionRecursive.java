package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SolutionRecursive {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> output = new ArrayList<>();
    comb(candidates, target, 0, 0, new ArrayList<>(), "", output, new HashSet<>(), target);
    return output;
  }

  private void comb(int[] candidates, int trg, int startIndex, int accSum, List<Integer> acc, String accStr,
                    List<List<Integer>> output, HashSet<String> outputHash, int initTrg) {
    if (trg == 0) {
      output.add(new ArrayList<>(acc));
      return;
    }

    if (trg < 0 || startIndex >= candidates.length || trg < candidates[startIndex] || accSum >= initTrg) {
      return;
    }

    for (int i = startIndex; i < candidates.length; i++) {
      String newHash = accStr + "_" + candidates[i];

      if (!outputHash.contains(newHash)) {
        acc.add(candidates[i]);
        outputHash.add(newHash);
        comb(candidates, trg - candidates[i], i+1, accSum + candidates[i], acc, newHash, output, outputHash,
            initTrg);
        acc.remove(acc.size() - 1);
      }
    }
  }
}
