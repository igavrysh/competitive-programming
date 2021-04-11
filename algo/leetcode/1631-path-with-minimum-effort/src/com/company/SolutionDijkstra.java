package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionDijkstra {
  public int minimumEffortPath(int[][] heights) {
    if (heights.length == 1 && heights[0].length == 1) {
      return 0;
    }
    // int[0] - next V, int[1] - cost to go to V
    List<List<Integer[]>> G = new ArrayList<>();

    int h = heights.length;
    int w = heights[0].length;
    Integer min = Integer.MAX_VALUE;
    Integer max = 0;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        List<Integer[]> N = new ArrayList<>();
        int nI, nJ;
        if (i != 0) {
          nI = i-1;
          nJ = j;
          int val = Math.abs(heights[nI][nJ]-heights[i][j]);
          N.add(new Integer[]{nI * w + nJ, val});
          min = Math.min(min, val);
          max = Math.max(max, val);
        }
        if (j != 0) {
          nI = i;
          nJ = j-1;
          int val = Math.abs(heights[nI][nJ]-heights[i][j]);
          N.add(new Integer[]{nI * w + nJ, val});
          min = Math.min(min, val);
          max = Math.max(max, val);
        }
        if (i != h-1) {
          nI = i+1;
          nJ = j;
          int val = Math.abs(heights[nI][nJ]-heights[i][j]);
          N.add(new Integer[]{nI * w + nJ, val});
          min = Math.min(min, val);
          max = Math.max(max, val);
        }
        if (j != w-1) {
          nI = i;
          nJ = j+1;
          int val = Math.abs(heights[nI][nJ]-heights[i][j]);
          N.add(new Integer[]{nI * w + nJ, val});
          min = Math.min(min, val);
          max = Math.max(max, val);
        }
        G.add(N);
      }
    }
    return dijkstra(G);
  }

  private int dijkstra(List<List<Integer[]>> G) {
    int globalE = 0;
    Integer[] D = new Integer[G.size()];
    for (int i = 0; i < D.length; i++) {
      D[i] = Integer.MAX_VALUE;
    }
    D[0] = 0;

    PriorityQueue<Integer> F = new PriorityQueue<>((Integer a, Integer b) -> {
      return D[a] - D[b];
    });
    for (Integer i = 0; i < G.size(); i++) {
      F.add(i);
    }

    while (F.size() != 0) {
      Integer v = F.poll();

      if (globalE < D[v]) {
        globalE = D[v];
      }

      if (v == G.size()-1) {
        return globalE;
      }

      for (Integer[] nxt : G.get(v)) {
        Integer nxtDist = Math.max(D[v], nxt[1]);
        if (D[nxt[0]] > nxtDist) {
          F.remove(nxt[0]);
          D[nxt[0]] = nxtDist;
          F.offer(nxt[0]);
        }
      }
    }
    return -1;
  }
}
