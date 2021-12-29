package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionImproved {

  public int maxEvents(int[][] events) {
    Arrays.sort(events, (int[] e1, int[] e2) -> { return e1[0] - e2[0]; });
    PriorityQueue<Integer> pq = new PriorityQueue<>((Integer e1, Integer e2) -> { return e1-e2; });
    int output = 0;
    int e = 0;

    int day = 1;
    while (day <= 100_000) {
      // no events in the queue - skip to earliest next event
      if (pq.size() == 0) {
        day = events[e][0];
      }

      // clear up all events that we missed (that were sitting in queue and ended before current day)
      while (pq.size() > 0 && pq.peek() < day) {
        pq.poll();
      }

      // enqueue all events that started today
      while (e < events.length && events[e][0] == day) {
        pq.offer(events[e][1]);
        e++;
      }

      // attend one event that ends earliest today
      if (pq.size() > 0) {
        pq.poll();
        output++;
      }

      if (e == events.length && pq.size() == 0) {
        break;
      }

      day += 1;
    }
    return output;
  }
}
