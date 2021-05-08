package com.company;

import java.util.Arrays;

public class Solution {

  public int bagOfTokensScore(int[] tokens, int P) {
    Arrays.sort(tokens);
    int score = 0;
    int maxScoreReached = 0;
    int l = 0;
    int r = tokens.length - 1;
    while (l <= r) {
      if (P >= tokens[l]) {
        score++;
        P -= tokens[l];
        l++;
        if (maxScoreReached < score) {
          maxScoreReached = score;
        }
      } else if (score > 0) {
        P += tokens[r];
        r--;
        score--;
      } else {
        break;
      }
    }
    return maxScoreReached;
  }

}
