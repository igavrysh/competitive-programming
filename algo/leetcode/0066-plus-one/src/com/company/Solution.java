package com.company;

public class Solution {
  public int[] plusOne(int[] digits) {
    int carry = 1;
    for (int i = digits.length-1; i >= 0; i--) {
      int sum = carry + digits[i];
      digits[i] = sum % 10;
      carry = sum / 10;
    }
    if (carry == 0) {
      return digits;
    }
    int[] output = new int[digits.length+1];
    for (int i = digits.length-1; i >= 0; i--) {
      output[i+1] = digits[i];
    }
    output[0] = carry;
    return output;
  }
}
