package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionPQ {
  public boolean carPooling(int[][] trips, int capacity) {
    // idx 0 - end time, idx 1 - capacity
    PriorityQueue<Integer[]> PQ
        = new PriorityQueue<>((Integer[] p1, Integer[] p2) -> { return p1[0] - p2[0]; });
    Arrays.sort(trips, (int[] t1, int[] t2) -> { return t1[1] - t2[1]; });

    for (int i = 0; i < trips.length; i++) {
      int[] trip = trips[i];

      // clean PQ from trips that ended
      while (!PQ.isEmpty() && PQ.peek()[0] <= trip[1]) {
        PQ.poll();
      }

      // list of trips to update capacity
      List<Integer[]> toRequeue = new ArrayList<>();
      boolean alreadyIncluded = false;
      while (!PQ.isEmpty() && PQ.peek()[0] <= trip[2]) {
        Integer[] p = PQ.poll();
        // update capacity for all trips that end before current trip
        p[1] += trip[0];
        if (p[0] == trip[2]) {
          alreadyIncluded = true;
        }
        toRequeue.add(p);
      }

      // if there are trips that is going to end later than current,
      // we need to get capacity from them,
      // the trip that is going to end the soonest contains all capacity we need
      if (!PQ.isEmpty()) {
        Integer[] p = PQ.peek();
        trip[0] += p[1];
      }
      if (!alreadyIncluded) {
        toRequeue.add(new Integer[]{trip[2], trip[0]});
      }

      // re - enqueue trips
      for (int j = 0; j < toRequeue.size(); j++) {
        if (toRequeue.get(j)[1] > capacity) {
          return false;
        }
        PQ.offer(toRequeue.get(j));
      }
    }
    return true;
  }
}
