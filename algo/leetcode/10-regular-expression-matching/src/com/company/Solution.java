package com.company;

import java.util.*;

class Solution {
  public boolean isMatch(String s, String p) {
    List<Set<Integer>> E = new ArrayList<>();
    List<Character> V = new ArrayList<>();
    List<Boolean> isOptional = new ArrayList<>();
    s = "s" + s + "e";
    p = "s" + p + "e";

    for (int i = 0; i < p.length(); i++) {
      Character c = p.charAt(i);
      if (c != '*') {
        V.add(c);
        E.add(new HashSet<>());
        isOptional.add(Boolean.FALSE);
      } else {
        isOptional.set(isOptional.size() - 1, Boolean.TRUE);
      }

      if (c != '*' && V.size() > 1) {
        Set<Integer> e = E.get(V.size() - 2);
        e.add(V.size() - 1);
      } else if (c == '*' && V.size() > 0) {
        Set<Integer> e = E.get(V.size() - 1);
        e.add(V.size() - 1);
        if (V.size() > 2) {
          Set<Integer> ePrev = E.get(V.size() - 2);
        }
      }
    }
    if (V.size() == 0 && s.length() == 0) {
      return true;
    }

    if (V.size() == 0 && s.length() != 0) {
      return false;
    }

    return DFS(0, s, 0, E, V, isOptional);
  }

  private boolean DFS(
      int i,
      String s,
      int j,
      List<Set<Integer>> E,
      List<Character> V,
      List<Boolean> isOptional
  ) {
    if (i >= s.length()) {
      return false;
    }

    if (i == s.length() - 1 && j == V.size() - 1) {
      return true;
    }

    Character c = s.charAt(i);
    Character p = V.get(j);
    Boolean isOpt = isOptional.get(j);
    boolean result = false;
    if (p == '.' || c == p) {
      Set<Integer> e = E.get(j);
      for (Integer adj : e) {
        boolean output = DFS(i + 1, s, adj, E, V, isOptional);
        if (output == true) {
          result = true;
        }
      }
    }

    if (isOpt) {
      Set<Integer> e = E.get(j);
      for (Integer adj : e) {
        if (adj.equals(Integer.valueOf(j))) {
          boolean output = DFS(i, s, adj, E, V, isOptional);
          if (output == true) {
            result = true;
          }
        }
      }
    }

    return result;
  }
}