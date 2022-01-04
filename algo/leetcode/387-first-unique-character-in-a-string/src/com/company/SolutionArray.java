package com.company;

class SolutionArray {
  public int firstUniqChar(String s) {
    int[] fq = new int[26];
    for (int i = 0; i < fq.length; i++) {
      fq[i] = -1;
    }
    char[] S = s.toCharArray();
    int counter = 0;
    for (int i = 0; i < S.length; i++) {
      if (counter == 26) {
        return -1;
      }
      char c = S[i];
      if (fq[c-'a'] != -1) {
        if (fq[c-'a'] != -2) {
          fq[c-'a'] = -2;
          counter++;
        }

      } else {
        fq[c-'a'] = i;
      }
    }
    int minIndex = -1;
    for (int i = 0; i < fq.length; i++) {
      if (fq[i] != -2 && fq[i] != -1) {
        if (fq[i] < minIndex || minIndex == -1) {
          minIndex = fq[i];
        }
      }
    }
    return minIndex;
  }
}