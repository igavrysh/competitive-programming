package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionRecursive {
  public List<List<Integer>> permuteUnique(int[] nums) {
    Integer[] fq = new Integer[21];
    for (int i = 0; i < nums.length; i++) {
      if (fq[nums[i]+10] == null) {
        fq[nums[i]+10] = 1;
      } else {
        fq[nums[i]+10]++;
      }
    }
    List<List<Integer>> output = new ArrayList<>();
    backtack(fq, nums.length, new ArrayList<>(), output);
    return output;
  }

  public void backtack(Integer[]fq, int tSize, List<Integer> acc, List<List<Integer>> output) {
    if (acc.size() == tSize) {
      output.add(new ArrayList<>(acc));
    }
    for (int i = 0; i < fq.length; i++) {
      if (fq[i] != null && fq[i] > 0) {
        fq[i]--;
        acc.add(i-10);
        backtack(fq, tSize, acc, output);
        acc.remove(acc.size()-1);
        fq[i]++;
      }
    }
  }
}
