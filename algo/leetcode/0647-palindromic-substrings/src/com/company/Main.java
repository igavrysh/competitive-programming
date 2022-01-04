package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int result = s.countSubstrings("abc");
    boolean passed = result == 3;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int result = s.countSubstrings("aaa");
    boolean passed = result == 6;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
