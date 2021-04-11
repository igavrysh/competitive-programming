package com.company;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public String minWindow(String s, String t) {
    Map<Character, Integer> T = new HashMap<>();
    for (Character c : t.toCharArray()) {
      if (T.get(c) == null) {
        T.put(c, 1);
      } else {
        T.put(c, T.get(c)+1);
      }
    }

    int sizeW = 0;
    Map<Character, Integer> W = new HashMap<>();
    int l = 0;
    int minLength = 0;
    for (int r = 0; r < s.length(); r++) {
      while (sizeW == t.length() && l <= r) {
        char c = s.charAt(l);
        W.put(c, W.get(c)-1);
        if (T.get(c) != null) {
          sizeW--;
        }
      }

    }

  }
}
