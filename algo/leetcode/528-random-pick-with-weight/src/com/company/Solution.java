package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
  private Random rand;
  private Integer upperBound;
  private List<Integer[]> m;

  public Solution(int[] w) {
    m = new ArrayList<>();
    Integer totalWeight = 0;
    int leftBound = 0;
    for (int i = 0; i < w.length; i++) {
      Integer weight = w[i];
      totalWeight += weight;
      m.add(new Integer[] {leftBound, leftBound + weight, i});
      leftBound += weight;
    }
    upperBound = totalWeight;
    rand = new Random();
  }

  public int pickIndex() {
    Integer e = rand.nextInt(upperBound);
    for (Integer[] bound : m) {
      if (bound[0] <= e && bound[1] > e) {
        return bound[2];
      }
    }
    return -1;
  }
}
