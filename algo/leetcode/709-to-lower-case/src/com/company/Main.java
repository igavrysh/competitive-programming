package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    String output = s.toLowerCase("Hello");
    boolean passed = output.equals("hello");
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
