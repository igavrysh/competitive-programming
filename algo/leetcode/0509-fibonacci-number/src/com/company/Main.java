package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.fib(3);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.fib(4);
    boolean passed = output == 3;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
