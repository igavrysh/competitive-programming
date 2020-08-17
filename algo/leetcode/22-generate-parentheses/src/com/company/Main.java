package com.company;

import java.util.List;

public class Main {

  static void test1() {
    Solution solution = new Solution();
    List<String> output = solution.generateParenthesis(3);
    boolean passed = output.contains("()()()")
        && output.contains("(())()")
        && output.contains("()(())")
        && output.contains("((()))")
        && output.contains("(()())")
        && output.size() == 5;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
