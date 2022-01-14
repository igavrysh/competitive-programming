package com.company;

import java.util.Arrays;

public class Solution {
  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (int[] b1, int[] b2) -> { return b1[0] - b2[0]; });
    int l = points[0][0];
    int r = points[0][1];
    int arrows = 1;
    for (int i = 1; i < points.length; i++) {
      if (l <= points[i][1] && r >= points[i][0]) {
        l = Math.max(l, points[i][0]);
        r = Math.min(r, points[i][1]);
      } else {
        arrows++;
        l = points[i][0];
        r = points[i][1];
      }
    }
    return arrows;
  }
}
