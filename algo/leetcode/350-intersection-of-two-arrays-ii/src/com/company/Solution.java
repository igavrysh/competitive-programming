package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    int p1 = 0;
    int p2 = 0;

    Arrays.sort(nums1);
    Arrays.sort(nums2);

    List<Integer> acc = new ArrayList<>();

    while (p1 < nums1.length && p2 < nums2.length) {
      if (nums1[p1] == nums2[p2]) {
        acc.add(nums1[p1]);
        p2++;
        p1++;
      } else if (nums1[p1] > nums2[p2]) {
        p2++;
      } else {
        p1++;
      }
    }

    int[] output = new int[acc.size()];
    for(int i = 0; i < output.length; i++) {
      output[i] = acc.get(i);
    }
    return output;
  }
}
