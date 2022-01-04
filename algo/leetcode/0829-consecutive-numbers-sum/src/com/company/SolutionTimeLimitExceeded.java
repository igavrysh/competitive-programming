package com.company;

import java.util.ArrayList;

public class SolutionTimeLimitExceeded {

  public int consecutiveNumbersSum(int n) {
    int counter = 0;
    ArrayList<Double> results = new ArrayList<>();

    for (int s = 1; s <= n; s++) {
      double a = 1;
      double b = (2.0*s + 1.0);
      double c = 2.0*(s-n);

      double dSq = Math.pow(b, 2.0) - 4.0*a*c;
      if (dSq < 0) {
        continue;
      }
      double d = Math.sqrt(dSq);
      double s1 = (-b + d) / (2.0 * a);
      double s2 = (-b - d) / (2.0 * a);

      if (s1 >= 0 && Math.round(s1)-s1 == 0.0) {
        results.add(s1);
        counter++;
      }
      if (s2 >= 0 && Math.round(s1)-s1 == 0.0) {
        results.add(s2);
        counter++;
      }
    }
    return counter;
  }

}
