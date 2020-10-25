package com.company;

public class Solution {
  public String toLowerCase(String str) {
    StringBuilder sb = new StringBuilder(str);
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c - 'A' >= 0 && c - 'A' <= 26) {
        sb.setCharAt(i, (char)((int)c+32));
      }
    }
    return sb.toString();
  }
}
