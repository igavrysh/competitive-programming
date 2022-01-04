package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.integerBreak(2);
    boolean passed = output == 1;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.integerBreak(10);
    boolean passed = output == 36;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    int output = s.integerBreak(3);
    boolean passed = output == 2;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    //test1();
    test2();
    test3();
  }
}
