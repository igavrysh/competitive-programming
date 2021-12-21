package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionBFS {

  public int findCircleNum(int[][] isConnected) {
    int N = isConnected.length;
    int[] visited = new int[N];
    int count = 0;
    Queue<Integer> Q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      if (visited[i] == 0) {
        count++;
        Q.add(i);
        while (!Q.isEmpty()) {
          int j = Q.poll();
          visited[j] = 1;
          for (int s = 0; s < N; s++) {
            if (visited[s] == 0 && isConnected[j][s] == 1) {
              Q.add(s);
            }
          }
        }
      }
    }
    return count;
  }
}
