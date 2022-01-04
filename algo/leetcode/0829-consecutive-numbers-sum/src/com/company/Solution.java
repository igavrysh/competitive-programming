package com.company;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class Solution {

  public int consecutiveNumbersSum(int n) {
    int counter = 0;

    List<Pair<Double, Double>> result = new ArrayList<>();

    for (int k = 0; k < n; k++) {
      if (k > Math.sqrt(2 * n + 1/4.0) + 1/2.0) {
        break;
      }
      double x = n / (k + 1.0) - k / 2.0;
      if (x > 0 && Math.abs(x - Math.round(x)) == 0) {
        result.add(new Pair<Double, Double>(x, (double)k));
        counter++;
      }
    }

    return counter;
  }

}
