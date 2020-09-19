package com.company;

import java.util.*;

public class Solution {
  public List<String> removeInvalidParentheses(String s) {
    int l = 0;
    int r = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        l++;
      }

      if (c == ')') {
        if (l == 0) {
          r++;
        } else {
          l--;
        }
      }
    }

    Map<Integer, Set<String>> output = new HashMap<>();
    generateValidParentheses(s, 0, 0, 0, l, r, 0, "", output);

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
      String s, int i, int l, int r, int remL, int remR, int removedBrackets, String acc, Map<Integer, Set<String>> output
  ) {
    if (i >= s.length()) {
      if (l == r && remL == 0 && remR == 0) {
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
      generateValidParentheses(s, i+1, l, r, remL, remR, removedBrackets, acc + s.charAt(i), output);
    } else {
      if (s.charAt(i) == '(') {
        generateValidParentheses(s, i+1, l+1, r, remL, remR, removedBrackets, acc + '(', output);
        if (remL > 0) {
          generateValidParentheses(s, i + 1, l, r, remL-1, remR,removedBrackets + 1, acc, output);
        }
      } else if (s.charAt(i) == ')') {
        if (l > r) {
          generateValidParentheses(s, i+1, l, r+1, remL, remR, removedBrackets, acc + ')', output);
        }

        if (remR > 0) {
          generateValidParentheses(s, i+1, l, r, remL, remR - 1, removedBrackets+1, acc, output);
        }
      }
    }
  }
}
