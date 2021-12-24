package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int countBinarySubstrings(String s) {
    List<Integer> groups = new ArrayList<>();
    int counter = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i == 0 || s.charAt(i - 1) == s.charAt(i)) {
        counter++;
      } else if (s.charAt(i-1) != s.charAt(i)) {
        groups.add(counter);
        counter = 1;
      }

      if (i == s.length()-1) {
        groups.add(counter);
      }
    }

    int output = 0;
    for (int i = 1; i < groups.size(); i++) {
      output += Math.min(groups.get(i-1), groups.get(i));
    }
    return output;
  }
}
