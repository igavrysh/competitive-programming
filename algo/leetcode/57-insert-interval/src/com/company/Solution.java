package com.company;

public class Solution {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    int l = -1;
    int r = -1;
    int newSize = 0;
    for (int i = 0; i < intervals.length; i++) {
      if (intervals[i][1] < newInterval[0] && l == -1) {
        newSize++;
      }

      if (intervals[i][1] >= newInterval[0] && l == -1) {
        l = Math.min(intervals[i][0], newInterval[0]);
        r = Math.max(intervals[i][1], newInterval[1]);
        intervals[i] = new int[]{0, 0};
      }

      if (r != -1) {
        if (intervals[i][0] <= r) {
          r = Math.max(intervals[i][1], r);
          intervals[i] = new int[]{0, 0};
        } else {
          newSize += intervals.length - i;
          i = intervals.length;
        }
      }
    }

    newSize += 1;

    return null;
  }
}
