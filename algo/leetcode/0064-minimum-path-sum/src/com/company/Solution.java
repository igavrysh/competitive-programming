package com.company;

public class Solution {

  public int minPathSum(int[][] grid) {
    if (grid.length == 0
        || (grid.length > 0) && grid[grid.length-1].length == 0) {
      return 0;
    }

    int[][] DP = new int[grid.length][grid[0].length];
    for (int i=0; i<grid.length; i++) {
      for (int j=0; j<grid[i].length; j++) {
        int moveFromUp = i-1>=0 ? DP[i-1][j] : -1;
        int moveFromLeft = j-1>=0 ? DP[i][j-1] : -1;

        int cost = grid[i][j];
        if (moveFromLeft != -1 && moveFromUp != -1) {
          cost += Math.min(moveFromUp, moveFromLeft);
        } else if (moveFromLeft == -1 && moveFromUp != -1) {
          cost += moveFromUp;
        } else if (moveFromLeft != -1 && moveFromUp == -1) {
          cost += moveFromLeft;
        }

        DP[i][j] = cost;
      }
    }

    return  DP[DP.length-1][DP[DP.length-1].length-1];
  }
}
