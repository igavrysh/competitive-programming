package com.company;

public class Solution {
  public String multiply(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();
    int[] n1 = new int[num1.length()];
    for (int i = 0; i < n1.length; i++) {
      n1[i] = num1.charAt(i) - '0';
    }
    int []result = new int[len1 + len2];
    for (int i = 0; i < len2; i++) {
      for (int j = 0; j < len1; j++) {
        result[i+j] += (n1[len1-1-j]) * (num2.charAt(len2-1-i) - '0');
      }
    }
    int carry = 0;
    for (int i = 0; i < result.length; i++) {
      int tmp = result[i] + carry;
      result[i] = tmp % 10;
      carry = tmp / 10;
    }
    boolean startAppending = false;
    StringBuilder sb = new StringBuilder();
    for (int i = result.length-1; i >= 0; i--) {
      if (result[i] != 0) {
        startAppending = true;
      }
      if (startAppending) {
        sb.append(result[i]);
      }
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
