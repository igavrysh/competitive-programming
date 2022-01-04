package com.company;

public class Main {

  public static void test1() {
    String input = "/home/";
    Solution s = new Solution();
    String output = s.simplifyPath(input);
    boolean passed = output.equals("/home");
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String input = "/../";
    Solution s = new Solution();
    String output = s.simplifyPath(input);
    boolean passed = output.equals("/");
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String input = "/home//foo/";
    Solution s = new Solution();
    String output = s.simplifyPath(input);
    boolean passed = output.equals("/home/foo");
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    String input = "/a/./b/../../c/";
    Solution s = new Solution();
    String output = s.simplifyPath(input);
    boolean passed = output.equals("/c");
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
