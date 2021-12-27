package com.company;

public class Solution {
  public int numPairsDivisibleBy60(int[] time) {
    int[] fq = new int[60];
    int output = 0;
    for (int i = 0; i < time.length; i++) {
      int compl = 60 - (time[i] % 60);
      if (compl == 60) {
        compl = 0;
      }
      if (fq[compl] == 0) {
        fq[time[i]%60] = 1;
      } else {
        output+= fq[compl];
        fq[time[i]%60] += 1;
      }
    }
    return output;
  }

}
