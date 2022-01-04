package com.company;

public class Solution {
  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }

    for (int i = 0; i < haystack.length(); i++) {
      int j = 0;
      while(haystack.length() > i+j
          && needle.length() > j
          && haystack.charAt(i+j) == needle.charAt(j)
      ) {
        j++;
      }

      if (j == needle.length()) {
        return i;
      }
    }
    return -1;
  }
}
