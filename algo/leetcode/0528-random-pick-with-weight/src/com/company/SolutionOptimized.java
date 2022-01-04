package com.company;

import java.util.Random;

public class SolutionOptimized {
  private Random rand;
  private Integer upperBound;
  private int[] F;

  public SolutionOptimized(int[] w) {
    F = new int[w.length];
    Integer totalWeight = 0;
    int acc = 0;
    for (int i = 0; i < w.length; i++) {
      acc += w[i];
      F[i] = acc;
    }
    upperBound = F[F.length-1];
    rand = new Random();
  }

  public int pickIndex() {
    Integer e = rand.nextInt(upperBound);
    int l = 0;
    int r = F.length - 1;

    while (l < r) {
      int mid = l + (r - l) / 2;
      if (F[mid] - 1 == e) {
        return mid;
      }
      if (F[mid] <= e) {
        l = mid + 1;
      } else if (F[mid] > e) {
        r = mid;
      }
    }
    return r;
  }
}
