package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int jump(int[] nums) {
    ArrayList<Integer>[] r = new ArrayList[nums.length];
    for (int i = 0; i < nums.length; i++) {
      r[i] = new ArrayList();
    }
    int[] DP = new int[nums.length];
    DP[0] = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 1; i <= nums[i]; j++) {
        r[i+j].add(i);
      }
    }


    return 0;
  }
}
