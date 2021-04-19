package com.company;

public class Solution {
  public String multiply(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();
    Integer []result = new Integer[len1 + len2];
    for (int i = 0; i < result.length; i++) {
      result[i] = null;
    }
    for (int i = 0; i < len2; i++) {
      for (int j = 0; j < len1; j++) {
        int toAppend = (num1.charAt(len1-1-j) - '0') * (num2.charAt(len2-1-i) - '0');
        result[i+j] = (result[i+j] == null ? 0 : result[i+j])
            + toAppend;
      }
    }
    int carry = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = result.length-1; i >= 0; i--) {
      if (result[i] == null || result[i] == 0 ) {
        result[i] = null;
      } else {
        break;
      }
    }
    for (int i = 0; i < result.length; i++) {
      if (result[i] == null && carry == 0) {
        break;
      }
      int currRes = result[i] == null ? 0 : result[i];
      sb.insert(0, (currRes + carry) % 10);
      carry = (currRes + carry - ((currRes+ carry) % 10)) / 10;
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
