package com.company;

public class Solution {
  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    int ia = a.length()-1;
    int ib = b.length()-1;
    while (ia >= 0 || ib >= 0 || carry > 0) {
      int sum = (ia >= 0 ? a.charAt(ia)-'0' : 0)
          + (ib >= 0 ? b.charAt(ib)-'0' : 0)
          + carry;
      if (ia >= 0) {
        ia--;
      }
      if (ib >= 0) {
        ib--;
      }
      sb.insert(0, String.valueOf(sum % 2));
      carry = sum / 2;
    }
    return sb.toString();
  }
}
