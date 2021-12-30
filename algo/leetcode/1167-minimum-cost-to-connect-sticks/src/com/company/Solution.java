package com.company;

import java.util.PriorityQueue;

public class Solution {

  public int connectSticks(int[] sticks) {
    PriorityQueue<Integer> PQ = new PriorityQueue<>((Integer i1, Integer i2) -> { return i1 - i2; });
    for (int s : sticks) {
      PQ.add(s);
    }

    int output = 0;
    while (PQ.size() != 1) {
      int s1 = PQ.poll();
      int s2 = PQ.poll();
      output += s1 + s2;
      PQ.add(s1+s2);
    }
    return output;
  }
}
