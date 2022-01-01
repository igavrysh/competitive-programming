package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public int getFood(char[][] grid) {
    int startI = 0, startJ = 0;
    int nI = grid.length, nJ = grid[0].length;
    for (int i = 0; i < nI; i++) {
      for (int j = 0; j < nJ; j++) {
        if (grid[i][j] == '*') {
          startI = i;
          startJ = j;
          i = nI;
          j = nJ;
        }
      }
    }

    Queue<Integer[]> q = new LinkedList<>();
    q.offer(new Integer[]{startI,startJ,0});

    int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    boolean[][] been = new boolean[nI][nJ];

    while (!q.isEmpty()) {
      Integer[] curr = q.poll();
      for (int s = 0; s < dirs.length; s++) {
        int nextI = curr[0] + dirs[s][0];
        int nextJ = curr[1] + dirs[s][1];
        int nextDist = curr[2] + 1;

        if (!(nextI >= 0 && nextI < nI && nextJ >= 0 && nextJ < nJ)) {
          continue;
        }
        if (grid[nextI][nextJ] == '#') {
          return nextDist;
        } else if (grid[nextI][nextJ] == 'O' && been[nextI][nextJ] == false) {
          been[nextI][nextJ] = true;
          q.offer(new Integer[]{nextI, nextJ, nextDist});
        }
      }
    }
    return -1;
  }

}
