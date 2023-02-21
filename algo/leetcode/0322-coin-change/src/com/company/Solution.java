package com.company;

import java.util.Arrays;

public class Solution {

    private int EMPTY_VALUE;
    private static int NO_SOLUTION = -1;
    private static int INITIAL_MIN_VALUE = -2;

    public int coinChange(int[] coins, int amount) {
        EMPTY_VALUE = amount + 1;
        if (amount == 0) {
            return 0;
        }

        Arrays.sort(coins);
        int[] bestOptions = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            bestOptions[i] = EMPTY_VALUE;
        }
        bestOptions[0] = 0;
        coinChangeInternal(coins, amount, bestOptions);
        return bestOptions[amount];
    }

    private void coinChangeInternal(int[] coins, int amount, int[] bestOptions) {
        int bestOptionsForAmount = INITIAL_MIN_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int target = amount - coins[i];
            if (target < 0) {
                break;
            }
            if (bestOptions[target] == EMPTY_VALUE) {
                coinChangeInternal(coins, target, bestOptions);
            }
            if (bestOptions[target] != NO_SOLUTION) {
                if (bestOptionsForAmount > (1 + bestOptions[target])
                        || bestOptionsForAmount == INITIAL_MIN_VALUE) {
                    bestOptionsForAmount = 1 + bestOptions[target];
                }
            }
        }
        if (bestOptionsForAmount == INITIAL_MIN_VALUE) {
            bestOptions[amount] = NO_SOLUTION;
        } else {
            bestOptions[amount] = bestOptionsForAmount;
        }
    }
}
