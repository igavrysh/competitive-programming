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

    Integer bestLength = Integer.MAX_VALUE;
    String output = "";

    Map<Character, Integer> S = new HashMap<>();
    int l = 0;
    int r = 0;
    int minLength = 0;
    String currentString = "";
    for (r = 0; r < s.length(); r++) {
      currentString = s.substring(l, r);

      if (match(S, T)) {
        while (l <= r && match(S, T)) {
          currentString = s.substring(l, r);

          if (bestLength > (r-l+1)) {
            bestLength = r-l+1;
            output = s.substring(l, r);
          }

          char lC = s.charAt(l);
          S.put(lC, S.get(lC)-1);
          l++;
        }
      }

      char rC = s.charAt(r);
      if (S.get(rC) == null) {
        S.put(rC, 1);
      } else {
        S.put(rC, S.get(rC) + 1);
      }
    }

    if (match(S, T)) {
      while (l <= r && match(S, T)) {
        currentString = s.substring(l, r);

        if (bestLength > (r-l+1)) {
          bestLength = r-l+1;
          output = s.substring(l, r);
        }

        char lC = s.charAt(l);
        S.put(lC, S.get(lC)-1);
        l++;
      }
    }

    return output;
  }

  private boolean match(Map<Character, Integer> S, Map<Character, Integer> T) {
    for (Character c : T.keySet()) {
      if (S.get(c) == null || S.get(c) < T.get(c)) {
        return false;
      }
    }
    return true;
  }
}
