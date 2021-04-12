package com.company;

import java.util.PriorityQueue;

public class SolutionExperiment {
  public int minimumEffortPath(int[][] heights) {
    if (heights.length == 1 && heights[0].length == 1) {
      return 0;
    }
    int rows = heights.length;
    int cols = heights[0].length;
    Integer[][] dist = new Integer[rows][cols];

    Integer[][] dist2 = new Integer[rows][cols];


    PriorityQueue<int[]> q = new PriorityQueue<>((int[] a, int[] b) -> a[2] - b[2]);
    dist[0][0] = 0;
    q.offer(new int[]{0,0,0});

    PriorityQueue<int[]> q2 = new PriorityQueue<>((int[] a, int[] b) -> dist2[a[0]][a[1]] - dist2[b[0]][b[1]]);
    dist2[0][0] = 0;
    q2.offer(new int[]{0,0});


    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while (!q.isEmpty() || !q2.isEmpty()) {
      int[] hiddenV1 = q.peek();
      int[] hiddenV2 = q2.peek();
      if (hiddenV1[0] != hiddenV2[0] || hiddenV1[1] != hiddenV2[1]) {
        int t = 1;
      }

      int[] v = q.poll();

      int[] v2 = q2.poll();
      if (v[0] != v2[0] || v[1] != v2[1]) {
        System.out.println("comp failed");
      } else {
        System.out.println("comp succeed");

      }

      if (v[0] == rows-1 && v[1] == cols-1) {
        return v[2];
      }

      for (int[] d : dirs) {
        int r = v[0] + d[0];
        int c = v[1] + d[1];
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
          continue;
        }

        int adjDis = Math.max(v[2], Math.abs(heights[r][c] - heights[v[0]][v[1]]));
        if (dist[r][c] == null || dist[r][c] > adjDis) {
          dist[r][c] = adjDis;

          dist2[r][c] = adjDis;

          q.offer(new int[]{r, c, adjDis});

          q2.offer(new int[]{r, c});
        }
      }
    }
    return -1;
  }

  /*
  public int minimumEffortPath(int[][] heights) {
    if (heights.length == 1 && heights[0].length == 1) {
      return 0;
    }
    int rows = heights.length;
    int cols = heights[0].length;
    Integer[][] dist = new Integer[rows][cols];

    PriorityQueue<int[]> q = new PriorityQueue<>((int[] a, int[] b) -> dist[a[0]][a[1]] - dist[b[0]][b[1]]);
    dist[0][0] = 0;
    q.offer(new int[]{0,0});

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while (!q.isEmpty()) {
      int[] v = q.poll();
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
          q.offer(new int[]{r, c});
        }
      }
    }
    return -1;
  }
   */
}
