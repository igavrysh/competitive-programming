package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> output = new ArrayList<>();
    Set<String> cache = new HashSet<>();
    combinations(new ArrayList<>(), output, target, candidates, 0, cache);

    Set<String> unique = new HashSet<>();
    int i = 0;
    while (i < output.size()) {
      List<Integer> acc = output.get(i);
      String key = accToString(acc);
      if (unique.contains(key)) {
        output.remove(i);
      } else {
        unique.add(key);
        i++;
      }
    }
    return output;
  }

  private String accToString(List<Integer> acc) {
    String output = "";
    for (Integer i : acc) {
      output += Integer.toString(i) + "_";
    }
    return output;
  }

  private void combinations(
      List<Integer> acc,
      List<List<Integer>> output,
      int target,
      int[] candidates,
      int startIndex,
      Set<String> cache
  ) {

    if (target <= 0 || startIndex >= candidates.length) {
      if (target == 0) {
        output.add(new ArrayList<>(acc));
      }
      return;
    }

    int nextStartIndex1 = startIndex + 1;
    int nextTarget1 = target - candidates[startIndex];

    acc.add(candidates[startIndex]);
    combinations(
        acc,
        output,
        nextTarget1,
        candidates,
        nextStartIndex1,
        cache);
    acc.remove(acc.size() - 1);

    int nextStartIndex2 = startIndex;
    int nextTarget2 = target - candidates[startIndex];
    acc.add(candidates[startIndex]);
    combinations(
        acc,
        output,
        nextTarget2,
        candidates,
        nextStartIndex2,
        cache);
    acc.remove(acc.size() - 1);

    int nextStartIndex3 = startIndex + 1;
    int nextTarget3 = target;
    combinations(
        acc,
        output,
        nextTarget3,
        candidates,
        nextStartIndex3,
        cache);

  }
}
