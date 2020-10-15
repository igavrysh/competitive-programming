package com.company;

public class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }

    int mIdx = -1;
    for (int idx = 0; idx < strs[0].length(); idx++) {
      mIdx = idx;
      char t = strs[0].charAt(idx);
      for (int i = 1; i < strs.length; i++) {
        if (strs[i].length() <= idx) {
          mIdx = idx-1;
          idx = strs[0].length();
          break;
        } else {
          if (strs[i].charAt(idx) != t) {
            mIdx = idx-1;
            idx = strs[0].length();
            break;
          }
        }
      }
    }
    return strs[0].substring(0, mIdx+1);
  }
}
