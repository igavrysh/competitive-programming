package com.company;

import java.util.*;

class Solution {
  public List<String> removeInvalidParentheses(String s) {
    Map<Integer, Set<String>> output = new HashMap<>();
    generateValidParentheses(s, 0, 0, 0, 0, "", output);

    if (output.size() == 0) {
      return Arrays.asList(new String[] {""});
    }

    int gMin = -1;
    for (Integer i : output.keySet()) {
      if (gMin == -1) {
        gMin = i;
      }

      if (gMin > i) {
        gMin = i;
      }
    }
    return new ArrayList<>(output.get(gMin));
  }

  private void generateValidParentheses(
      String s, int i, int l, int r, int removedBrackets, String acc, Map<Integer, Set<String>> output
  ) {
    if (i >= s.length()) {
      if (l == r) {
        Set<String> o = output.get(removedBrackets);
        if (o == null) {
          o = new HashSet<>();
          output.put(removedBrackets, o);
        }
        o.add(acc);
      }
      return;
    }

    if (s.charAt(i) != '('
      && s.charAt(i) != ')'
    ) {
      generateValidParentheses(s, i+1, l, r, removedBrackets, acc + s.charAt(i), output);
    } else {
      if (s.charAt(i) == '(') {
        generateValidParentheses(s, i+1, l+1, r, removedBrackets, acc + '(', output);
        generateValidParentheses(s, i+1, l, r, removedBrackets+1, acc, output);
      } else if (s.charAt(i) == ')') {
        if (l > r) {
          generateValidParentheses(s, i+1, l, r+1, removedBrackets, acc + ')', output);
        }
        generateValidParentheses(s, i+1, l, r, removedBrackets+1, acc, output);
      }
    }
  }
}