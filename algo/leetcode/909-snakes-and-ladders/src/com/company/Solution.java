package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  public int snakesAndLadders(int[][] board) {
    int N = board.length;
    Queue<Integer[]> queue = new LinkedList<>();
    queue.add(new Integer[]{1,0});
    boolean[][] visited = new boolean[N][N];
    visited[N-1][0] = true;
    while (queue.size() > 0) {
      Integer[] curr = queue.poll();
      if (curr[0] == N*N) {
        return curr[1];
      }
      for (int i = 1; i <= 6; i++) {
        int nextIdx = Math.min(curr[0] + i, N*N);
        int r = N-1 - (nextIdx-1)/N;
        int c = (nextIdx-1)/N %2 == 0 ? (nextIdx-1)%N : N-1 - (nextIdx-1)%N;

        if (visited[r][c] == false) {
          visited[r][c] = true;
          if (board[r][c] != -1) {
            nextIdx = board[r][c];
          }
          queue.add(new Integer[]{nextIdx, curr[1]+1});
        }
      }
    }
    return -1;
  }
}
