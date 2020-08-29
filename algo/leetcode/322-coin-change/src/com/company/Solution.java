package com.company;

import java.util.Arrays;

public class Solution {

  public int coinChange(int[] coins, int amount) {
    Arrays.sort(coins);
    int[] bestOptions = new int[amount + 1];
    for (int i = 0; i <= amount; i++) {
      bestOptions[i] = -1;
    }
    bestOptions[0] = 0;
    coinChangeInternal(coins, amount, bestOptions);
    return bestOptions[amount];
  }

  private void coinChangeInternal(int[] coins, int amount, int[] bestOptions) {
    int bestOptionsForAmount = -2;
    for (int i = 0; i < coins.length; i++) {
      int target = amount - coins[i];
      if (target < 0) {
        break;
      }
      if (bestOptions[target] == -1) {
        coinChangeInternal(coins, target, bestOptions);
      }
      if (bestOptions[target] != -1) {
        if (bestOptionsForAmount > (1 + bestOptions[target])
            || bestOptionsForAmount == -2) {
          bestOptionsForAmount = 1 + bestOptions[target];
        }
      }
    }
    if (bestOptionsForAmount != -1 && bestOptionsForAmount != -2) {
      bestOptions[amount] = bestOptionsForAmount;
    }
  }
}
