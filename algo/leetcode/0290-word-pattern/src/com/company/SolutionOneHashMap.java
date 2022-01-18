package com.company;

import java.util.HashMap;

public class SolutionOneHashMap {
  public boolean wordPattern(String pattern, String s) {
    HashMap M = new HashMap();
    String[] words = s.split(" ");
    if (words.length != pattern.length()) {
      return false;
    }
    int N = pattern.length();
    for (Integer i = 0; i < N; i++) {
      Integer charIdx = (Integer)M.get(pattern.charAt(i));
      if (charIdx == null) {
        M.put(pattern.charAt(i), i);
      }

      Integer wordIdx = (Integer)M.get(words[i]);
      if (wordIdx == null) {
        M.put(words[i], i);
      }

      // Checks below are required if variable i in iteration above has type int instead of Integer
      /*
      if ((stringIdx == null && charIdx != null)
          || (stringIdx != null && !stringIdx.equals(charIdx))) {
       */

      if (charIdx != wordIdx) {
        return false;
      }
    }
    return true;
  }
}
