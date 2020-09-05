package com.company;

public class Main {
  public static void test1() {
    String s = "abc";
    String t = "ahbgdc";
    Solution solution = new Solution();
    boolean output = solution.isSubsequence(s, t);
    boolean passed = output == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String s = "axc";
    String t = "ahbgdc";
    Solution solution = new Solution();
    boolean output = solution.isSubsequence(s, t);
    boolean passed = output == false;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
