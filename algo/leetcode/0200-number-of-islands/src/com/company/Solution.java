package com.company;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int numIslands(char[][] grid) {
    maxNum = 0;
    if (grid.length == 0) {
      return 0;
    }
    int NM = grid.length * grid[0].length;
    int[] UF = new int[NM];
    for (int i = 0; i < NM; i++) {
      UF[i] = -1;
    }
    int N = grid.length;
    int M = grid[0].length;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] != '1') {
          continue;
        }

        UF[i*M + j] = maxNum++;

        if (i-1 >= 0 && grid[i-1][j] == grid[i][j]) {
          Union(UF, (i-1)*M+j, i*M + j);
        }
        if (i+1 < N && grid[i+1][j] == grid[i][j]) {
          Union(UF, (i+1)*M+j, i*M + j);
        }
        if (j-1 >= 0 && grid[i][j-1] == grid[i][j]) {
          Union(UF, i*M+j-1, i*M + j);
        }
        if (j+1 < M && grid[i][j+1] == grid[i][j]) {
          Union(UF, i*M+j+1, i*M + j);
        }
      }
    }
    Set<Integer> unique = new HashSet<Integer>();
    for (int i = 0; i < UF.length; i++) {
      if (UF[i] != -1) {
        unique.add(UF[i]);
      }
    }
    return unique.size();
  }

  private int maxNum = 0;
  private void Union(int[] UF, int i, int j) {
    if (UF[i] == -1 && UF[j] != -1) {
      UF[i] = UF[j];
    }

    if (UF[i] != -1 && UF[j] == -1) {
      UF[j] = UF[i];
    }

    int min = Math.min(UF[i], UF[j]);
    int max = Math.max(UF[i], UF[j]);
    for (int k = 0; k < UF.length; k++) {
      if (UF[k] == max) {
        UF[k] = min;
      }
    }
  }
}

