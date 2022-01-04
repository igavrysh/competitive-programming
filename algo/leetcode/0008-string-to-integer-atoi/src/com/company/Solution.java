package com.company;

public class Solution {
  public int myAtoi(String s) {
    if (s.length() == 0) {
      return 0;
    }

    long output = 0;
    int sign = 0;

    int i = 0;
    while (i < s.length() && s.charAt(i) == ' ') {
      i++;
    }

    if (i >= s.length()) {
      return 0;
    }

    char c = s.charAt(i);
    if (c == '+' || (c-'0' >= 0 && c-'0'<=9)) {
      sign = 1;
      if (c == '+') {
        i++;
      }
    }

    if (c == '-') {
      sign = -1;
      i++;
    }

    if (i >= s.length()) {
      return 0;
    }
    c = s.charAt(i);

    if (!(c-'0' >= 0 && c-'0'<=9)) {
      return 0;
    }

    while (c-'0' >= 0 && c-'0'<=9 && i < s.length()) {
      output = output * 10 + (c-'0');
      if ((output * sign) > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }

      if ((output * sign) < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }

      i++;
      if (i < s.length()) {
        c = s.charAt(i);
      }
    }
    return (int)output * sign;
  }
}
