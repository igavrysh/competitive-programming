package com.company;

import java.util.Arrays;

public class Solution {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (int1, int2) -> { return int1[0] - int2[0]; });
    int l = intervals[0][0];
    int r = intervals[0][1];
    int k = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] > r) {
        intervals[k][0] = l;
        intervals[k][1] = r;
        k++;

        l = intervals[i][0];
        r = intervals[i][1];
      } else if (intervals[i][0] <= r && intervals[i][1] > r) {
        r = intervals[i][1];
      }
    }
    intervals[k][0] = l;
    intervals[k][1] = r;
    k++;
    int[][] output = new int[k][2];
    for (int i = 0; i < k; i++) {
      output[i] =  intervals[i];
    }
    return output;
  }
}
