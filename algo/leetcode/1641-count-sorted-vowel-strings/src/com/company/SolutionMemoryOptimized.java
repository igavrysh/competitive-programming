package com.company;

public class SolutionMemoryOptimized {
  public int countVowelStrings(int n) {
    int vowels = 5;
    int[] DP = new int[vowels+1];
    for (int i = 0; i < DP.length; i++) {
      DP[i] = i;
    }

    int[] nextDP = new int[vowels+1];

    for (int j = 2; j <= n; j++) {
      for (int i = 0; i <= vowels; i++) {
        if (i == 0) {
          nextDP[i] = 0;
        } else if (i == 1 ) {
          nextDP[i] = 1;
        } else {
          int value = 0;
          for (int ii = 1; ii <= i; ii++) {
            value += DP[ii];
          }
          nextDP[i] = value;
        }
      }
      int[] tmp = DP;
      DP = nextDP;
      nextDP = tmp;
    }
    return DP[vowels];
  }

}
