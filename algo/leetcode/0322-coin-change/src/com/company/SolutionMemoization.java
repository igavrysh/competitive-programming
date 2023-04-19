package com.company;

import java.util.HashMap;

public class SolutionMemoization {

    public int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        int res = f(amount, cache, coins);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int f(int amount, HashMap<Integer, Integer> cache, int[] coins)  {
        if (cache.get(amount) != null) {
            return cache.get(amount);
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }

        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int acc = f(amount-coins[i], cache, coins);
            if (acc != Integer.MAX_VALUE) {
                acc += 1;
            }
            minCount = Math.min(minCount, acc);
        }
        cache.put(amount, minCount);
        
        return minCount;
    }
}
