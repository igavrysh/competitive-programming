package com.company;

public class Solution {
  public int numPairsDivisibleBy60(int[] time) {
    int[] fq = new int[60];
    int output = 0;
    for (int i = 0; i < time.length; i++) {
      fq[time[i]%60] += 1;
    }

    for (int i = 0; i < fq.length; i++) {
      if (fq[i] != 0) {
        int compl = (60 - i)%60;

        // number of combinations pairs out of fq[i]
        if (i == compl) {
          output += fq[i] * (fq[i] - 1) / 2;
          fq[compl] = 0;
          continue;
        }

        // othewise simple multiplication
        output += fq[i] * fq[compl];
        fq[i] = 0;
        fq[compl] = 0;
      }
    }
    return output;
  }

}
