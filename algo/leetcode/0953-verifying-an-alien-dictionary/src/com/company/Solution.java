package com.company;

public class Solution {
  public boolean isAlienSorted(String[] words, String order) {
    int[] dictionary = new int[32];
    for (int i = 0; i < order.length(); i++) {
      dictionary[order.charAt(i) - 'a'] = i;
    }

    for (int i = 0; i < words.length - 1; i++) {
      int maxN = Math.max(words[i].length(), words[i + 1].length());
      for (int j = 0; j < maxN; j++) {
        int delta =
            (j < words[i].length()
                ? dictionary[words[i].charAt(j) - 'a']
                : -1)
                - (j < words[i + 1].length()
                ? dictionary[words[i + 1].charAt(j) - 'a']
                : -1
            );
        if (delta == 0) {
          continue;
        }

        if (delta > 0) {
          return false;
        }

        if (delta < 0) {
          break;
        }
      }
    }

    return true;
  }
}
