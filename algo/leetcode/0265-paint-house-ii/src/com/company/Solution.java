package com.company;

public class Solution {
  public int minCostII(int[][] costs) {
    int N = costs.length;
    int K = costs[0].length;
    int [][] DP = new int[N][K];
    DP[0] = costs[0];
    for (int i = 1; i < N; i++) {
      int min=-1, minJ=-1, secondMin=-1, secondMinJ=-1;
      if (DP[i-1][0]<=DP[i-1][1]) {
        min=DP[i-1][0];
        minJ=0;
        secondMin=DP[i-1][1];
        secondMinJ=1;
      } else {
        min=DP[i-1][1];
        minJ=1;
        secondMin=DP[i-1][0];
        secondMinJ=0;
      }
      for (int j = 2; j < K; j++) {
        if (DP[i-1][j] <= min) {
          secondMin = min;
          secondMinJ = minJ;
          min = DP[i-1][j];
          minJ = j;
        } else if (DP[i-1][j] <= secondMin) {
          secondMin = DP[i-1][j];
          secondMinJ = j;
        }
      }
      for (int j = 0; j < K; j++) {
        if (j != minJ) {
          DP[i][j] = costs[i][j] + DP[i-1][minJ];
        } else {
          DP[i][j] = costs[i][j] + DP[i-1][secondMinJ];
        }
      }
    }
    int res = DP[N-1][0];
    for (int j = 0; j < K; j++) {
      if (DP[N-1][j] < res) {
        res = DP[N-1][j];
      }
    }
    return res;
  }
}
