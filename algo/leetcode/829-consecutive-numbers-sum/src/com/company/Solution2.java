package com.company;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class Solution2 {

  public int consecutiveNumbersSum(int n) {
    int counter = 0;

    List<Pair<Double, Double>> result = new ArrayList<>();

    double threshold = Math.sqrt(2 * n + 1/4.0) + 1/2.0;
    for (int k = 0; k <= threshold; k++) {
      if  ( (2 * n - k * (k+1)) % (2*(k+1)) == 0 && 2 * n - k * (k+1) > 0) {
        counter++;
      }
    }

    return counter;
  }

}
