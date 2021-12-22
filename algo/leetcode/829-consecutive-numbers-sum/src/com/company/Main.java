package com.company;

public class Main {
  public static void test1() {
    Solution s = new Solution();
    int output = s.consecutiveNumbersSum(5);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.consecutiveNumbersSum(9);
    boolean passed = output == 3;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    int output = s.consecutiveNumbersSum(15);
    boolean passed = output == 4;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    int output = s.consecutiveNumbersSum(855204);
    boolean passed = output == 8;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }


  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
