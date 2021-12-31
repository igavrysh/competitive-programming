package com.company;

import java.util.Arrays;

public class SolutionSort {

  public int maxProfit(int[] inventory, int orders) {
    long m = 1_000_000_007;

    Arrays.sort(inventory);
    int digits = 1;
    long accOrders = 0;
    long accProfit = 0;
    for (int i = inventory.length-1; i >= 0; i--) {
      if (accOrders == orders) {
        break;
      }
      long inv = (long)inventory[i];
      long nextinv = 0;
      if (i-1 >= 0) {
        nextinv = inventory[i-1];
      }

      if (orders < accOrders + (inv - nextinv) * digits) {
        long ordersFillLeft = orders - accOrders;
        long fullRounds = ordersFillLeft / digits;

        accOrders += (fullRounds) * digits;
        accProfit = (accProfit + digits * (inv + (inv-fullRounds)  + 1) * (inv - (inv-fullRounds)) / 2) % m;

        ordersFillLeft = ordersFillLeft % digits;
        accOrders += ordersFillLeft;
        accProfit = (accProfit + ordersFillLeft * (inv - fullRounds)) % m;
      }
      else {
        accOrders += (inv - nextinv) * digits;
        accProfit = (accProfit + digits * (inv + nextinv + 1)*(inv - nextinv)/2) % m;
        digits++;
      }
    }
    return (int)(accProfit%m);
  }

}
