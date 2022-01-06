package com.company;

public class SolutionAcc {
  public boolean carPooling(int[][] trips, int capacity) {
    int maxTime = -1;
    for (int i = 0; i < trips.length; i++) {
      if (maxTime < trips[i][2]) {
        maxTime = trips[i][2];
      }
    }
    int[] timestamp = new int[maxTime+1];
    for (int[] trip : trips) {
      timestamp[trip[1]] += trip[0];
      timestamp[trip[2]] -= trip[0];
    }

    int curr = 0;
    for (int i = 0; i < timestamp.length; i++) {
      curr += timestamp[i];
      if (curr > capacity) {
        return false;
      }
    }
    return true;
  }
}
