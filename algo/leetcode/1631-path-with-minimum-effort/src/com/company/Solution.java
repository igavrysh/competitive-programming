package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
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
    boolean[] visited = new boolean[G.size()];
    int globalE = 0;
    Integer[] D = new Integer[G.size()];
    for (int i = 0; i < visited.length; i++) {
      visited[i] = false;
      D[i] = Integer.MAX_VALUE;
    }
    // front horizon
    List<Integer> F = new ArrayList<>();

    F.add(0);
    visited[0] = true;
    D[0] = 0;
    int cV = 0;

    while (true) {
      int nxtV = -1;
      int minD = Integer.MAX_VALUE;
      for (int vert : F) {
        for (Integer[] nxt : G.get(vert)) {
          if (!visited[nxt[0]]) {
            if (D[nxt[0]] > Math.max(D[vert], nxt[1])) {
              D[nxt[0]] = Math.max(D[vert], nxt[1]);
            }

            if (D[nxt[0]] < minD) {
                minD = D[nxt[0]];
                nxtV = nxt[0];
            }
          }
        }
      }

      if (nxtV == -1) {
        break;
      }

      cV = nxtV;
      visited[cV] = true;
      globalE = Math.max(globalE, minD);
      F.add(cV);

      if (nxtV == G.size()-1) {
        return globalE;
      }
    }
    return -1;
  }
}
