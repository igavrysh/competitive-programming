package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionDFS {

  public int minimumEffortPath(int[][] heights) {
    if (heights.length == 1 && heights[0].length == 1) {
      return 0;
    }
    // int[0] - next V, int[1] - cost to go to V
    List<List<int[]>> G = new ArrayList<>();

    int h = heights.length;
    int w = heights[0].length;
    int min = 10000000;
    int max = 0;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        List<int[]> N = new ArrayList<>();
        int nI, nJ;
        if (i != 0) {
          nI = i - 1;
          nJ = j;
          int val = Math.abs(heights[nI][nJ] - heights[i][j]);
          N.add(new int[]{nI * w + nJ, val});
          min = Math.min(min, val);
          max = Math.max(max, val);
        }
        if (j != 0) {
          nI = i;
          nJ = j - 1;
          int val = Math.abs(heights[nI][nJ] - heights[i][j]);
          N.add(new int[]{nI * w + nJ, val});
          min = Math.min(min, val);
          max = Math.max(max, val);
        }
        if (i != h - 1) {
          nI = i + 1;
          nJ = j;
          int val = Math.abs(heights[nI][nJ] - heights[i][j]);
          N.add(new int[]{nI * w + nJ, val});
          min = Math.min(min, val);
          max = Math.max(max, val);
        }
        if (j != w - 1) {
          nI = i;
          nJ = j + 1;
          int val = Math.abs(heights[nI][nJ] - heights[i][j]);
          N.add(new int[]{nI * w + nJ, val});
          min = Math.min(min, val);
          max = Math.max(max, val);
        }
        G.add(N);
      }
    }

    int r = max;
    int l = min;
    int lastPossible = -1;
    while (l <= r) {
      int m = l + (r - l) / 2;

      boolean[] visited = new boolean[G.size()];
      for (int i = 0; i < visited.length; i++) {
        visited[i] = false;
      }

      if (pathExists(0, visited, G, m)) {
        r = m - 1;
        lastPossible = m;
      } else {
        l = m + 1;
      }
    }
    return lastPossible;
  }

  private boolean pathExists(int v, boolean[] visited, List<List<int[]>> G, int k) {
    if (v == G.size()-1) {
      return true;
    }
    for (int[] nxt : G.get(v)) {
      if (!visited[nxt[0]] && nxt[1] <= k) {
        visited[nxt[0]] = true;
        if (pathExists(nxt[0], visited, G, k)) {
          return true;
        }
        visited[nxt[0]] = false;
      }
    }
    return false;
  }

}
