package com.company;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    HashMap<Integer, Integer> comb = new HashMap<>();
    for (int i = 0; i < nums3.length; i++) {
      for (int j = 0; j < nums4.length; j++) {
        int key = nums3[i] + nums4[j];
        int value = comb.getOrDefault(key, 0);
        comb.put(key, value+1);
      }
    }
    int res = 0;
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        int toFind = - (nums1[i] + nums2[j]);
        if (comb.get(toFind) != null) {
          res += comb.get(toFind);
        }
      }
    }
    return res;
  }
}