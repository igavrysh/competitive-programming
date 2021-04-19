package com.company;

public class Solution {
  public String multiply(String num1, String num2) {
    int[] n1 = new int[num1.length()];
    int[] n2 = new int[num2.length()];
    for (int i = 0; i < num1.length(); i++) {
      n1[num1.length()-1-i] = num1.charAt(i) - '0';
    }
    for (int  i= 0; i < num2.length(); i++) {
      n2[num2.length() - 1 - i] = num2.charAt(i) - '0';
    }
    int[][] acc = new int [n2.length][n1.length + n2.length];
    int s = 0;
    int carry = 0;
    for (int i = 0; i < n2.length; i++) {
      carry = 0;
      for (int j = 0; j < n1.length; j++) {
        acc[i][j + s] = (n2[i] * n1[j] + carry) % 10;
        carry = ((n2[i] * n1[j] + carry) - ((n2[i] * n1[j] + carry) % 10)) / 10;
      }
      if (carry > 0) {
        acc[i][s + n1.length] = carry;
      }
      s++;
    }
    carry = 0;
    int[] result = new int[n1.length + n2.length];
    for (int j = 0; j < acc[0].length; j++) {
      int res = 0;
      for (int i = 0; i < acc.length; i++) {
        res += acc[i][j];
      }
      result[j] = (carry + res) % 10;
      carry = (carry + res) / 10;
    }
    StringBuilder sb = new StringBuilder();
    boolean start = false;
    for (int i = result.length-1; i >= 0; i--) {
      if (result[i] != 0) {
        start = true;
      }
      if (start) {
        sb.append(String.valueOf(result[i]));
      }
    }
    String output = sb.toString();
    return output.equals("") ? "0" : output;
  }
}
