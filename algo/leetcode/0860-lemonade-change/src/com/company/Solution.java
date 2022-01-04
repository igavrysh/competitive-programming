package com.company;

public class Solution {
  public boolean lemonadeChange(int[] bills) {
    int[] M = new int[3];
    M[0] = M[1] = M[2] = 0;

    for (int i = 0; i < bills.length; i++) {
      if (bills[i] == 5) {
        M[0] += 1;
      }
      if (bills[i] == 10) {
        M[1] += 1;
      }
      if (bills[i] == 20) {
        M[2] += 1;
      }

      if (bills[i] == 10) {
        if (M[0] == 0) {
          return false;
        }
        M[0] -= 1;
      }

      if (bills[i] == 20) {
        if ((M[1] >= 1 && M[0] >= 1)
          || M[0] >= 3
        ) {
          if (M[1] >= 1 && M[0] >= 1) {
            M[0] -= 1;
            M[1] -= 1;
          } else {
            M[0] -= 3;
          }
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
