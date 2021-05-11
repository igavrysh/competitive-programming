package com.company;

import java.util.Arrays;

public class Solution {
  public String getPermutation(int n, int k) {
    int[] num = new int[n];
    for (int i = 0; i < num.length; i++) {
      num[i] = i+1;
    }
    int t = 1;
    while (t < k) {
      for (int i = num.length-2; i >= 0; i--) {
        for (int j = num.length-1; j > i; j--) {
          if (num[i] < num[j]) {
            int valueToPaste = num[i];
            num[i] = num[j];
            num[j] = valueToPaste;
            Arrays.sort(num, i+1, num.length);
            i = -1;
            j = -1;
          }
        }
      }
      t++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < num.length; i++) {
      sb.append(String.valueOf(num[i]));
    }
    return sb.toString();
  }
}
