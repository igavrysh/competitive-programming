package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> hNums1 = new HashSet<>();
    for (int t : nums1) {
      hNums1.add(t);
    }
    Set<Integer> output = new HashSet<>();
    for (int t : nums2) {
      if (hNums1.contains(t)) {
        output.add(t);
      }
    }
    int[] pureOutput = new int[output.size()];
    int i = 0;
    for (int t : output) {
      pureOutput[i++] = t;
    }
    return pureOutput;
  }
}
