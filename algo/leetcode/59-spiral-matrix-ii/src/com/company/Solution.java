package com.company;

public class Solution {

  public int[][] generateMatrix(int n) {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int[][] output = new int[n][n];
    int counter = 1;
    int currQ = 0;
    int maxQ = n;
    int currI = 0;
    int currJ = 0;
    int currDir = 0;
    for (int i = 0; i < n*n; i++) {
      output[currI][currJ] = i+1;
      currQ++;
      if (currQ == maxQ) {
        if (counter == 1) {
          counter = 0;
          maxQ--;
        } else {
          counter = 1;
        }
        currQ = 0;
        currDir = (currDir + 1) % 4;
      }
      currI = currI + dirs[currDir][0];
      currJ = currJ + dirs[currDir][1];
    }
    return output;
  }
}
