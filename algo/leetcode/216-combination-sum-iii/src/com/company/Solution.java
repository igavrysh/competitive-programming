package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> output = new ArrayList<>();
    BT(1, 9, k, n, new ArrayList<>(), output);
    return output;
  }

  private void BT(int start, int end, int k, int target, List<Integer> acc, List<List<Integer>> result) {
    if (target == 0 && acc.size() == k) {
      result.add(new ArrayList<>(acc));
      return;
    }

    if (target < 0 || acc.size() > k || start > end) {
      return;
    }
    acc.add(start);
    BT(start+1, end, k, target-start, acc, result);
    acc.remove(acc.size()-1);
    BT(start+1, end, k, target, acc, result);
  }
}
