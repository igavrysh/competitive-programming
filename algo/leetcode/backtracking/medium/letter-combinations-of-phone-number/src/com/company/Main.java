package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  private static void test1() {
    Solution solution = new Solution();
    List<String> output = solution.letterCombinations("23");
    boolean checked = true;
    String[] expectedOutput = new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
    for (String eo : expectedOutput) {
      if (!output.contains(eo)) {
        checked = false;
      }
    }
    System.out.println("test1:" + (checked ? "passed" : "failed"));
  }

  private static void test2() {
    Solution solution = new Solution();
    List<String> output = solution.letterCombinations("");
    boolean checked = output.size() == 0;
    System.out.println("test2:" + (checked ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
