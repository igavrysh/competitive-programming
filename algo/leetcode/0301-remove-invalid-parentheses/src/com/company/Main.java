package com.company;

import java.util.List;

public class Main {

  public static void test1() {
    String input = "()())()";
    Solution s = new Solution();
    List<String> output = s.removeInvalidParentheses(input);
    boolean passed = output.size() == 2
        && output.contains("()()()")
        && output.contains("(())()");
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String input = "(a)())()";
    Solution s = new Solution();
    List<String> output = s.removeInvalidParentheses(input);
    boolean passed = output.size() == 2
        && output.contains("(a)()()")
        && output.contains("(a())()");
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String input = ")(";
    Solution s = new Solution();
    List<String> output = s.removeInvalidParentheses(input);
    boolean passed = output.size() == 1
        && output.contains("");
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
