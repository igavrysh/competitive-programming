package com.company;

public class SolutionConstantMemory {
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int k : nums) {
      result ^= k;
    }

    return result;
  }
}