package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    List<int[]>[] G = new ArrayList[n];
    for (int i = 0; i < G.length; i++) {
      G[i] = new ArrayList<>();
    }
    for (int i = 0; i < flights.length; i++) {
      int [] pair = flights[i];
      G[pair[0]].add(new int[] { pair[1], pair[2] });
    }

    PriorityQueue<int[]> q = new PriorityQueue<>((int[] a, int[] b) -> a[1] - b[1]);
    q.add(new int[]{src, 0, 0});
    while (!q.isEmpty()) {
      int[] curr = q.poll();
      if (curr[2] > K+1) {
        continue;
      }

      if (curr[0] == dst) {
        return curr[1];
      }
      for (int[] neighb : G[curr[0]]) {
        int aP = curr[1] + neighb[1];
        if (curr[2] <= K) {
          q.add(new int[]{neighb[0], aP, curr[2]+1});
        }
      }
    }
    return -1;
  }
}
