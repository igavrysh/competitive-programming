package com.company;

import java.util.PriorityQueue;

public class Solution {

  public int maxProfit(int[] inventory, int orders) {
    PriorityQueue<Integer> PQ = new PriorityQueue<>((Integer i1, Integer i2) -> { return i2 - i1; });
    for (int i : inventory) {
      PQ.add(i);
    }
    int m = (int)(7 + 10e9);
    int output = 0;
    while (PQ.size() > 0 && orders > 0) {
      int ball = PQ.poll();
      output = (output + ball)%m;
      if (ball-1 > 0) {
        PQ.add(ball-1);
      }
      orders--;
    }
    return output;
  }
}
