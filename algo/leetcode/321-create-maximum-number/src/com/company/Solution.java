package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int[] output = new int[k];
    int index = 0;
    int n1Index = 0;
    int n2Index = 0;
    int n1 = nums1.length - 1;
    int n2 = nums2.length - 1;
    while (index < k) {

      if (n1Index < nums1.length && n2Index < nums2.length) {
        if (nums1[n1 - n1Index] >= nums2[n2 - n2Index]) {
          output[index] = nums1[n1 - n1Index];
          n1Index += 1;
        } else {
          output[index] = nums2[n2 - n2Index];
          n2Index += 1;
        }
      } else if (n1Index < nums1.length) {
        output[index] = nums1[n1 - n1Index];
        n1Index += 1;
      } else if (n2Index < nums2.length) {
        output[index] = nums2[n2 - n2Index];
        n2Index += 1;
      }
      index++;
    }
    return output;
  }
}
