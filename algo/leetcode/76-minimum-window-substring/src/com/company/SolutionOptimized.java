package com.company;

import java.util.HashMap;
import java.util.Map;

public class SolutionOptimized {
  public String minWindow(String s, String t) {
    if (t.length() == 0) {
      return "";
    }
    Map<Character, Integer> T = new HashMap<>();
    for (Character c : t.toCharArray()) {
      if (T.get(c) == null) {
        T.put(c, 1);
      } else {
        T.put(c, T.get(c)+1);
      }
    }
    int formed = 0;
    int required = T.size();
    Integer bestLength = Integer.MAX_VALUE;
    Integer[] output = new Integer[] {Integer.MAX_VALUE, -1, -1};
    Map<Character, Integer> wdwFq = new HashMap<>();
    int l = 0;
    int r = 0;

    while (r < s.length()) {
    //for (r = 0; r < s.length(); r++) {
      char rC = s.charAt(r);
      int rCFq = wdwFq.getOrDefault(rC, 0);
      wdwFq.put(rC, rCFq + 1);
      if (T.containsKey(rC) && wdwFq.get(rC).intValue() == T.get(rC).intValue()) {
        formed++;
      }
      while (l <= r && formed == required) {
        if (output[0] > (r-l+1)) {
          output[0] = r-l+1;
          output[1] = l;
          output[2] = r;
        }
        char lC = s.charAt(l);
        wdwFq.put(lC, wdwFq.get(lC) - 1);
        if (T.containsKey(lC) && wdwFq.get(lC).intValue() == T.get(lC).intValue()-1) {
          formed--;
        }
        l++;
      }
      r++;
    }
    return output[0] == Integer.MAX_VALUE ? "" : s.substring(output[1], output[2]+1);
  }
}
