package com.company;

public class Solution {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length == 0) {
      int[][] res = new int[1][2];
      res[0][0] = newInterval[0];
      res[0][1] = newInterval[1];
      return res;
    }

    int size = 0;
    int insertPos = -1;
    for (int i = 0; i < intervals.length; i++) {
      if (intervals[i][1] < newInterval[0]) {
        size++;
      }

      if (intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
        newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
        intervals[i][0] = 1;
        intervals[i][1] = -1;
        if (insertPos == -1) {
          insertPos = size;
        }
      }

      if (intervals[i][0] > newInterval[0]) {
        size++;
      }
    }

    int[][] output = new int[size + 1][2];
    int k = 0;
    for (int i = 0; i < size+1; i++) {
      if (i == insertPos) {
        output[i] = newInterval;
        continue;
      }
      while (k < intervals.length && intervals[k][0] == 1 && intervals[k][1]== -1) {
        k++;
      }

      if (k >= intervals.length) {
        break;
      }
      output[i] = intervals[k];
      k++;
    }
    return output;
  }
}
