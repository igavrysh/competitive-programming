package com.company;

import java.util.PriorityQueue;

public class SolutionTimeLimitExceeded {

  public int maxProfit(int[] inventory, int orders) {
    PriorityQueue<Integer> PQ = new PriorityQueue<>((Integer i1, Integer i2) -> { return i2 - i1; });
    for (int i : inventory) {
      PQ.add(i);
    }
    long m = (long)(Math.pow(10, 9) + 7);
    long output = 0;
    while (PQ.size() > 0 && orders > 0) {
      int ball = PQ.poll();
      output = (output + ball)%m;
      if (ball-1 > 0) {
        PQ.add(ball-1);
      }
      orders--;
    }
    return (int)(output%m);
  }
}
