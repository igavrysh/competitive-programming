package com.company;

public class Solution {
  public boolean isNumber(String s) {
    boolean ePresent = false;
    boolean dotPresent = false;
    boolean positiveDigitBeforeDot = false;
    boolean positiveDigitAfterDot = false;
    boolean digitAfterDot = false;
    boolean positiveDigitAfterE = false;
    boolean digitAfterE = false;
    boolean positiveDigit = false;
    char[] C = s.toCharArray();
    for (int i = 0; i < C.length; i++) {
      if (!((Character.toLowerCase(C[i])-'a' >= 0
          && Character.toLowerCase(C[i])-'a' <= 25)
          || (C[i]-'0' >= 0
            && C[i]-'0' <= 9)
          || C[i] == 'e'
          || C[i] == 'E'
          || C[i] == '+'
          || C[i] == '-'
          || C[i] == '.')) {
        return false;
      }
      if (C[i] == '+' || C[i] == '-') {
        if (i == 0) {
          continue;
        } else {
          if (ePresent && (C[i-1] == 'e' || C[i-1] == 'E')) {
            continue;
          }
          return false;
        }
      }
      if (C[i]-'0' >= 0 && C[i]-'0'<= 9) {
        positiveDigit = true;
        if (dotPresent == true && C[i]-'0' > 0) {
          positiveDigitAfterDot = true;
        }
        if (dotPresent) {
          digitAfterDot = true;
        }
        if (ePresent == true && C[i]-'0' > 0) {
          positiveDigitAfterE = true;
        }
        if (ePresent) {
          digitAfterE = true;
        }
        continue;
      }
      if (C[i] == '.') {
        if (dotPresent || ePresent) {
          return false;
        }
        if (positiveDigit) {
          positiveDigitBeforeDot = true;
        }
        dotPresent = true;
        continue;
      }
      if (C[i] == 'E' || C[i] == 'e') {
        if (ePresent || !positiveDigit) {
          return false;
        }
        ePresent = true;
        continue;
      }
      return false;
    }
    if (ePresent && !digitAfterE) {
      return false;
    }
    if (dotPresent && !positiveDigitBeforeDot && !digitAfterDot) {
      return false;
    }
    return true;
  }
}
