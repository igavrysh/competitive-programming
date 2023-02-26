package com.company;

public class SolutionPractice2 {
    public int maxProfit(int[] prices) {
        int bestPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length;i++) {
            profit = Math.max(profit, prices[i]-bestPrice);
            bestPrice = Math.min(bestPrice, prices[i]);
        }
        return profit;
    }
}
