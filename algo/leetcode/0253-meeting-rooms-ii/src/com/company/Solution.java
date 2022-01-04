package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
  public int minMeetingRooms(int[][] intervals) {

    Arrays.sort(intervals, (int[] i1, int[] i2) -> {
      return i1[0] - i2[0];
    });

    PriorityQueue<Integer> pq = new PriorityQueue<>((Integer i1, Integer i2) -> {
      return i1 - i2;
    });

    for (int i = 0; i < intervals.length; i++) {
      if (pq.size() == 0 || pq.peek() > intervals[i][0]) {
        pq.add(intervals[i][1]);
      } else {
        pq.poll();
        pq.add(intervals[i][1]);
      }
    }

    return pq.size();
  }
}
