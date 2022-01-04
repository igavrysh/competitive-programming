package com.company;

public class SolutionStringBuffer {
  public String convert(String s, int numRows) {
    StringBuffer[] sb = new StringBuffer[numRows];
    for (int i = 0; i < sb.length; i++) {
      sb[i] = new StringBuffer();
    }
    int sIdx = 0;
    int len = s.length();
    while (sIdx < s.length()) {
      for (int row = 0; row < numRows && sIdx < len; row++) {
        sb[row].append(s.charAt(sIdx++));
      }
      for (int row = numRows - 2; row > 0 && sIdx < len; row--) {
        sb[row].append(s.charAt(sIdx++));
      }
    }
    for (int i = 1; i < sb.length; i++) {
      sb[0].append(sb[i]);
    }
    return sb[0].toString();
  }
}
