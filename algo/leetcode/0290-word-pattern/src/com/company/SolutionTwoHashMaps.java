package com.company;

import java.util.HashMap;

public class SolutionTwoHashMaps {
  public boolean wordPattern(String pattern, String s) {
    String[] strs = s.split(" ");
    HashMap<Character, String> patternToS = new HashMap<>();
    HashMap<String, Character> sToPattern = new HashMap<>();
    if (pattern.length() != strs.length) {
      return false;
    }
    int N = pattern.length();
    for (int i = 0; i < N; i++) {
      char c = pattern.charAt(i);

      String foundStr = patternToS.get(pattern.charAt(i));
      if (foundStr != null) {
        if (foundStr.compareTo(strs[i]) != 0) {
          return false;
        }
      } else {
        patternToS.put(c, strs[i]);
      }

      Character foundCharacter = sToPattern.get(strs[i]);
      if (foundCharacter != null) {
        if (foundCharacter != c) {
          return false;
        }
      } else {
        sToPattern.put(strs[i], c);
      }
    }
    return true;
  }
}
