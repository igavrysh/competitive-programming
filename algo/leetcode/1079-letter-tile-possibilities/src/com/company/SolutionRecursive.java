package com.company;

public class SolutionRecursive {
  public int numTilePossibilities(String tiles) {
    char[] C = tiles.toCharArray();
    int[] fq = new int[26];
    for (int i = 0; i < C.length; i++) {
      fq[C[i]-'A']++;
    }
    return BT(fq);
  }

  private int BT(int[] fq) {
    int acc = 0;
    for (int i = 0; i < fq.length; i++) {
      if (fq[i] > 0) {
        fq[i]--;
        acc += 1 + BT(fq);
        fq[i]++;
      }
    }
    return acc;
  }
}
