package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int orangesRotting(int[][] grid) {

    List<int[]> rottenXY = new ArrayList<>();
    int fresh = 0;
    int rotten = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          fresh += 1;
        }
        if (grid[i][j] == 2) {
          rotten += 1;
          rottenXY.add(new int[]{ i, j });
        }
      }
    }

    int timer = 0;
    boolean sizeIncreased = true;
    while (sizeIncreased) {
      sizeIncreased = false;
      List<int[]> nextRottenXY = new ArrayList<>();

      List<int[]> offsets = List.of(
          new int[] { 1, 0 },
          new int[] { -1, 0 },
          new int[] { 0, 1 },
          new int[] { 0, -1 } );

      for (int[] coord : rottenXY) {
        for (int[] offset : offsets) {
          int i = coord[0] + offset[0];
          int j = coord[1] + offset[1];
          if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length) {
            if (grid[i][j] == 1) {
              rotten += 1;
              fresh -= 1;
              grid[i][j] = 2;
              nextRottenXY.add(new int[]{i, j});
            }
          }
        }
      }

      if (nextRottenXY.size() > 0) {
        sizeIncreased = true;
        timer += 1;
      }

      rottenXY = nextRottenXY;
    }

    if (fresh > 0) {
      return -1;
    }

    return timer;
  }
}
