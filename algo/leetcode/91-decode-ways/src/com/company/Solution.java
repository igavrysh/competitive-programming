package com.company;

public class Solution {
  public int numDecodings(String s) {
    return num(s.toCharArray(), 0);
  }

  private int num(char[] s, int index) {
    if (index >= s.length) {
      return 1;
    }

    int output = 0;

    int curr = s[index] - '0';

    if (curr != 0) {
      output += num(s, index + 1);

      if (index+1 < s.length) {
        int next = s[index+1] - '0';
        if ((curr * 10 + next) <= 26) {
          output += num(s, index + 2);
        }
      }
    }
    return output;
  }
}
