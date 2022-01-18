package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class SolutionIterativeShorter {
  public int longestStrChain(String[] words) {
    Arrays.sort(words, (String w1, String w2) -> { return w1.length() - w2.length(); });
    // string, and chain
    int result = 1;
    HashMap<String, Integer> chainLength = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      chainLength.put(words[i], 1);

      for (int j = 0; j < words[i].length(); j++) {
        StringBuilder sb = new StringBuilder(words[i]);
        String reducedString = sb.deleteCharAt(j).toString();
        if (chainLength.containsKey(reducedString)) {
          int newMax = Math.max(chainLength.get(words[i]), chainLength.get(reducedString)+1);
          chainLength.put(words[i], newMax);
          if (result < newMax) {
            result = newMax;
          }
        }
      }
    }
    return result;
  }
}
