package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

  public int maxEvents(int[][] events) {
    Arrays.sort(events, (int[] e1, int[] e2) -> { return e1[0] - e2[0]; });
    PriorityQueue<Integer> pq = new PriorityQueue<>((Integer e1, Integer e2) -> { return e1-e2; });
    int output = 0;
    int d = 0;

    for (int i = 1; i <= 100_000; i++) {
      while (pq.size() > 0 && pq.peek() < i) {
        pq.poll();
      }

      while (d < events.length && events[d][0] == i) {
        pq.offer(events[d][1]);
        d++;
      }

      if (pq.size() > 0) {
        pq.poll();
        output++;
      }
    }
    return output;
  }
}
