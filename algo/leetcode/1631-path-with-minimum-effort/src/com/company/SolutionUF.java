package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionUF {

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

    int l = min;
    int r = max;
    int lastValid = r;
    while (l <= r) {
      int m = l + (r-l)/2;
      if (UF(m, G)) {
        lastValid = m;
        r = m-1;
      } else {
        l = m+1;
      }
    }
    return lastValid;
  }

  private boolean UF(int thr, List<List<Integer[]>> G) {
    int[] id = new int[G.size()];
    int[] w = new int[G.size()];
    for (int i = 0; i < id.length; i++) {
      id[i] = i;
      w[i] = 1;
    }

    Queue<Integer> q = new LinkedList<>();
    q.offer(0);
    while (id[0] != id[id.length-1] && q.size() != 0) {
      Integer v = q.poll();
      union(0, v, id, w);
      for (Integer[] adj : G.get(v)) {
        if (id[adj[0]] != id[0] && adj[1] <= thr) {
          q.offer(adj[0]);
        }
      }
    }
    return id[0] == id[id.length-1];
  }

  private int root(int i, int[] id) {
    while (id[i] != i) {
      i = id[i];
    }
    return i;
  }

  private void union(int i, int j, int[] id, int[] w) {
    int rootI = root(i, id);
    int rootJ = root(j, id);
    if (rootI == rootJ) {
      return;
    }
    if (w[rootI] >= w[rootJ]) {
      id[rootJ] = rootI;
      w[rootI] += w[rootJ];
    } else {
      id[rootI] = rootJ;
      w[rootJ] += w[rootI];
    }
  }
}
