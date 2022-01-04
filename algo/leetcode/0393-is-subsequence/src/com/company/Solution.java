package com.company;

public class Solution {

  public boolean isSubsequence(String s, String t) {
    if (s == null || s.length() == 0) {
      return true;
    }
    if (s.length() == 0 && t.length() == 0) {
      return true;
    }
    if (s.length() > 0 && t.length() == 0) {
      return false;
    }

    int j = 0;
    for (int i = 0; i < t.length(); i++) {
      if (j >= s.length()) {
        return true;
      }

      if (t.charAt(i) == s.charAt(j)) {
        j++;
      }
    }
    if (j >= s.length()) {
      return true;
    }
    return false;
  }
}
