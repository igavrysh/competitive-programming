package com.company;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean isSubsequence(String s, String t) {
    Map<String, Boolean> cache = new HashMap<>();
    return isSubseq(s, 0, t, 0, cache);
  }

  private boolean isSubseq(String s, int j, String t, int i, Map<String, Boolean> cache) {
    if (j >= s.length()) {
      return true;
    }

    if (j < s.length() && i >= t.length()) {
      return false;
    }

    String key = String.valueOf(i) + "_" + String.valueOf(j);

    if (cache.containsKey(key)) {
      return cache.get(key);
    }

    boolean output = false;
    if (s.charAt(j) == t.charAt(i)) {
      output = isSubseq(s, j+1, t, i+1, cache);
    }

    if (!output) {
      output = isSubseq(s, j, t, i+1, cache);
    }

    if (!cache.containsKey(key))  {
      cache.put(key, output);
    }

    return output;
  }
}