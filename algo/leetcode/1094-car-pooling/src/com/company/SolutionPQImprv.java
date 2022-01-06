package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionPQImprv {
  public boolean carPooling(int[][] trips, int capacity) {
    // idx 0 - end time, idx 1 - capacity
    PriorityQueue<Integer[]> PQ
        = new PriorityQueue<>((Integer[] p1, Integer[] p2) -> { return p1[0] - p2[0]; });
    Arrays.sort(trips, (int[] t1, int[] t2) -> { return t1[1] - t2[1]; });

    int curr = 0;

    for (int i = 0; i < trips.length; i++) {
      int[] trip = trips[i];

      // clean PQ from trips that ended
      while (!PQ.isEmpty() && PQ.peek()[0] <= trip[1]) {
        Integer[] p = PQ.poll();
        curr -= p[1];
      }

      PQ.offer(new Integer[]{trip[2],trip[0]});
      curr += trip[0];

      if (curr > capacity) {
        return false;
      }
    }
    return true;
  }
}