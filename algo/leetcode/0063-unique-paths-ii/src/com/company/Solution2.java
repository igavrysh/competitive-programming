package com.company;

public class Solution2 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    obstacleGrid[0][0] = -1;
    for (int i = 0; i < obstacleGrid.length; i++) {
      for (int j = 0; j < obstacleGrid[0].length; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        if (obstacleGrid[i][j] == 0) {
          obstacleGrid[i][j] = (j-1 >= 0 && obstacleGrid[i][j-1] < 0 ? obstacleGrid[i][j-1] : 0)
              + (i-1 >= 0 && obstacleGrid[i-1][j] < 0 ? obstacleGrid[i-1][j] : 0);
        }
      }
    }
    return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] < 0
        ? obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] * -1 : 0 ;
  }
}
