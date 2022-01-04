package com.company;

import java.util.*;

public class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    Map<String, Integer> D = new HashMap<>();
    int dLength = 0;
    for (String w : words) {
      if (D.containsKey(w)) {
        D.put(w, D.get(w)+1);
      } else {
        D.put(w, 1);
      }
      dLength += 1;
    }

    int wordLength = words[0].length();
    int totalLength = wordLength * words.length;
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i <= s.length()-totalLength; i++) {
      if (isFull(s, wordLength, i, 0, dLength, D)) {
        result.add(i);
      }
    }
    return result;
  }

  private boolean isFull(
      String s,
      int wordLength,
      int startIndex,
      int currLength,
      int dLength,
      Map<String, Integer> D
  ) {
    if (currLength == dLength) {
      return true;
    }

    if (s.length() <= startIndex) {
      return false;
    }

    String word = s.substring(startIndex, startIndex+wordLength);
    boolean result = false;

    if (D.get(word) != null && D.get(word) > 0) {
      D.put(word, D.get(word)-1);
      result = isFull(s, wordLength, startIndex+wordLength, currLength+1, dLength, D);
      D.put(word, D.get(word)+1);
    }
    return result;
  }
}
