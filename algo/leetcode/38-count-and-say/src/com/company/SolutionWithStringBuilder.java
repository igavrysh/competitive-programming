package com.company;

public class SolutionWithStringBuilder {
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
    StringBuilder sb = new StringBuilder();
    int counter = 1;
    for (int i=1; i<current.length(); i++) {
      if (current.charAt(i) == prevChar) {
        counter++;
      }

      if (current.charAt(i) != prevChar) {
        sb.append(counter).append(prevChar);
        counter = 1;
      }
      prevChar = current.charAt(i);
    }

    sb.append(counter).append(prevChar);

    return sb.toString();
  }
}
