package com.company;

public class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int maxPofit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i-1]) {
        maxPofit += prices[i] - prices[i-1];
      }
    }
    return maxPofit;
  }
}
