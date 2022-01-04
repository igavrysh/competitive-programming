package com.company;

public class Solution {
  public boolean isAdditiveNumber(String num) {
    String op1 = "";
    int i = 0;
    while (i < num.length()) {
      op1 += num.charAt(i);
      if (isAdt(op1, i+1, num)) {
        return true;
      }
      i++;
    }
    return false;
  }

  private boolean isAdt(String op1, int s, String num) {
    if (s >= num.length()) {
      return false;
    }
    String op2 = "";
    int i = s;
    while (i < num.length()) {
      op2 += num.charAt(i);
      if (op2.length() > 1 && op2.charAt(0) == '0') {
        return false;
      }
      String add = add(op1, op2);
      boolean match = true;
      for (int c = 0; c < add.length(); c++) {
        int idx = s+op2.length()+c;
        if (idx >= num.length() || add.charAt(c) != num.charAt(idx)) {
          match = false;
          break;
        }
      }
      if (match) {
        if (s + op2.length() + add.length() == num.length()) {
          return true;
        }
        if (isAdt(op2, s + op2.length(), num)) {
          return true;
        }
      }
      i++;
    }
    return false;
  }

  private String add(String op1, String op2) {
    int i = 0;
    int carry = 0;
    String output = "";
    while (i < op1.length() || i < op2.length() || carry > 0) {
      int res = (i < op1.length() ? op1.charAt(op1.length()-1-i) - '0' : 0) + (i < op2.length() ? op2.charAt(op2.length()-1-i) - '0' : 0) + carry;
      output = Integer.toString(res % 10) + output;
      carry = res / 10;
      i++;
    }
    return output;
  }
}
