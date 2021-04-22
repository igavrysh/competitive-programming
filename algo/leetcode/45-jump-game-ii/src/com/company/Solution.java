package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int jump(int[] nums) {
    ArrayList<Integer>[] r = new ArrayList[nums.length];
    for (int i = 0; i < nums.length; i++) {
      r[i] = new ArrayList();
    }
    Integer[] DP = new Integer[nums.length];
    DP[0] = 0;
    r[0].add(0);
    for (int i = 0; i < nums.length; i++) {
      for (int j = 1; j <= nums[i]; j++) {
        if (i+j < r.length) {
          r[i + j].add(i);
        }
      }
      Integer min = null;
      if (i != 0) {
        for (Integer j : r[i]) {
          if (DP[j] != null &&
              (min == null || min > (DP[j] + 1))) {
            min = DP[j] + 1;
          }
        }
        DP[i] = min;
      }
    }
    return DP[nums.length-1] == null
        ? -1
        : DP[nums.length-1].intValue();
  }
}
