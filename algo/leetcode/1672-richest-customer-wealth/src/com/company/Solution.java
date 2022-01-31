package com.company;

class Solution {
  public int maximumWealth(int[][] accounts) {
    int res = 0;
    int n = accounts.length;
    int m = accounts[0].length;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = 0; j < m; j++) {
        sum += accounts[i][j];
      }
      if (res<sum) {
        res = sum;
      }
    }
    return res;
  }
}