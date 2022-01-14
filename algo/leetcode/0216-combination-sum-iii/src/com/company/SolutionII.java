package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionII {

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> output = new ArrayList<>();
    bt(1, 0, new ArrayList<>(), output, k, n);
    return output;
  }

  // s: 1, c = 0, curr = []

  // s: 2, c = 1, curr = [1]
  // s: 3, c = 3, curr = [1,2]
  //


  // s: 3, c = 1, curr = [1]



  // s: 2, c = 0, curr = []

  private void bt(int start, int currSum, List<Integer> curr,
                  List<List<Integer>> output, int k, int n) {
    if (curr.size() >= k || currSum >= n) {
      if (curr.size() == k && currSum == n) {
        output.add(new ArrayList<>(curr));
      }
      return;
    }

    for (int i = start+1; i <= 9; i++) {
      curr.add(start);
      bt(i, currSum+start, curr, output, k, n);
      curr.remove(curr.size()-1);
      bt(i, currSum, curr, output, k, n);
    }
  }
}
