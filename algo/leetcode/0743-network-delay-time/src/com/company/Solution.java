package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private class Vertex {
    int to;
    int weight;

    Vertex(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  public int networkDelayTime(int[][] times, int N, int K) {
    List<List<Vertex>> G = new ArrayList<>();
    for (int i = 0; i < N; i++)  {
      G.add(new ArrayList<>());
    }

    for (int i = 0; i < times.length; i++) {
      int f = times[i][0]-1;
      int t = times[i][1]-1;
      int w = times[i][2];
      G.get(f).add(new Vertex(t, w));
    }

    int[] D = new int[N];
    for (int i = 0; i < D.length; i++) {
      D[i] = Integer.MAX_VALUE;
    }
    int[] P = new int[N];
    boolean[] visited = new boolean[N];
    for (int i = 0; i < visited.length; i++) {
      visited[i] = false;
    }
    P[K-1] = K-1;
    D[K-1] = 0;

    int visitedCount = 0;

    while (visitedCount != N) {
      int minLength = Integer.MAX_VALUE;
      int minI = -1;

      for (int i = 0; i < visited.length; i++) {
        if (visited[i] == false) {
          if (D[i] < minLength) {
            minLength = D[i];
            minI = i;
          }
        }
      }

      if (minI != -1) {
        visited[minI] = true;
        visitedCount++;

        List<Vertex> nVert = G.get(minI);
        for (int i = 0; i < nVert.size(); i++) {
          Vertex nextVert = nVert.get(i);
          int newDist = D[minI] + nextVert.weight;
          if (newDist < D[nextVert.to]) {
            D[nextVert.to] = newDist;
            P[nextVert.to] = minI;
          }
        }
      }

      if (minI == -1 && visitedCount != N) {
        return -1;
      }
    }

    int maxTime = -1;
    for (int i = 0; i < D.length; i++) {
      if (D[i] > maxTime) {
        maxTime = D[i];
      }
    }

    return maxTime;
  }
}

