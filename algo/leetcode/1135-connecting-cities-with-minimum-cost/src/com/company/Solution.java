package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  private int[] id;
  private int[] sz;

  private int find(int i) {
    while (id[i] != i) {
      i = id[i];
    }
    return i;
  }

  private void union(int p, int q) {
    int i = find(p);
    int j = find(q);
    if (sz[i] < sz[j]) {
      id[i] = j;
      sz[j] += sz[i];
    } else {
      id[j] = i;
      sz[i] += sz[j];
    }
  }

  private boolean connected(int v1, int v2) {
    return find(v1) == find(v2);
  }

  public int minimumCost(int n, int[][] connections) {
    id = new int[n];
    sz = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
      sz[i] = 1;
    }

    PriorityQueue<Integer[]> PQ = new PriorityQueue<>((Integer[] e1, Integer[] e2) -> {
      return e1[2] - e2[2];
    });
    for (int[] e : connections) {
      PQ.offer(new Integer[]{e[0]-1, e[1]-1, e[2]});
    }

    Queue<Integer[]> MST = new LinkedList<>();
    int cost = 0;
    while (PQ.size() > 0 && MST.size() < n-1) {
      Integer[] edge = PQ.poll();
      Integer v1 = edge[0];
      Integer v2 = edge[1];
      if (!connected(v1, v2)) {
        cost += edge[2];
        MST.offer(edge);
        union(v1, v2);
      }
    }
    return MST.size() < n-1 ? -1 : cost;
  }
}
