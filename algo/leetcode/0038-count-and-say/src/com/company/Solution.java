package com.company;

public class Solution {
  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }

    String current = "1";
    while (n-1 > 0) {
      current = nextCountAndSay(current);
      n--;
    }
    return current;
  }

  private String nextCountAndSay(String current) {
    char prevChar = current.charAt(0);
    String result = "";
    int counter = 1;
    for (int i=1; i<current.length(); i++) {
      if (current.charAt(i) == prevChar) {
        counter++;
      }

      if (current.charAt(i) != prevChar) {
        result += Integer.valueOf(counter).toString() + prevChar;
        counter = 1;
      }
      prevChar = current.charAt(i);
    }

    result += Integer.valueOf(counter).toString() + prevChar;

    return result;
  }
}
