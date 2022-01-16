package com.company;

public class Solution {
  public int maxDistToClosest(int[] seats) {
    int prev=-1, next=-1, maxDist = -1;
    for (int i = 0; i  < seats.length; i++) {
      if (seats[i] == 1) {
        if (next == -1) {
          next = i;
          if (maxDist < i) {
            maxDist = i;
          }
        } else {
          prev = next;
          next = i;
          int newDist = (next-prev)/2;
          if (maxDist < newDist) {
            maxDist = newDist;
          }
        }
      }
    }
    if (maxDist < (seats.length-1-next)) {
      maxDist = seats.length-1-next;
    }
    return maxDist;
  }
}
