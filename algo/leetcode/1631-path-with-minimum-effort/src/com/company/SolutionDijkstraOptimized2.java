package com.company;

import java.util.PriorityQueue;

public class SolutionDijkstraOptimized2 {
  public int minimumEffortPath(int[][] heights) {
    if (heights.length == 1 && heights[0].length == 1) {
      return 0;
    }
    int rows = heights.length;
    int cols = heights[0].length;
    Integer[][] dist = new Integer[rows][cols];

    PriorityQueue<int[]> q = new PriorityQueue<>((int[] a, int[] b) -> dist[a[0]][a[1]] - dist[b[0]][b[1]]);
    dist[0][0] = 0;

    int[][] map = new int[rows*cols][2];
    map[0] = new int[]{0,0};
    q.offer(map[0]);

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while (!q.isEmpty()) {
      int[] v = q.poll();
      map[v[0] * cols + v[1]] = null;
      if (v[0] == rows-1 && v[1] == cols-1) {
        return dist[v[0]][v[1]];
      }

      for (int[] d : dirs) {
        int r = v[0] + d[0];
        int c = v[1] + d[1];
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
          continue;
        }

        int adjDis = Math.max(dist[v[0]][v[1]], Math.abs(heights[r][c] - heights[v[0]][v[1]]));
        if (dist[r][c] == null || dist[r][c] > adjDis) {
          dist[r][c] = adjDis;
          q.remove(map[r * cols + c]);
          map[r * cols + c] = new int[]{r, c};
          q.offer(map[r * cols + c]);
        }
      }
    }
    return -1;
  }
}
