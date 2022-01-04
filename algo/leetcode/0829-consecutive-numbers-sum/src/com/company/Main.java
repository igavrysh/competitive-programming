package com.company;

public class Main {
  public static void test1() {
    Solution2 s = new Solution2();
    int output = s.consecutiveNumbersSum(5);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution2 s = new Solution2();
    int output = s.consecutiveNumbersSum(9);
    boolean passed = output == 3;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution2 s = new Solution2();
    int output = s.consecutiveNumbersSum(15);
    boolean passed = output == 4;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution2 s = new Solution2();
    int output = s.consecutiveNumbersSum(855204);
    boolean passed = output == 8;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    Solution2 s = new Solution2();
    int output = s.consecutiveNumbersSum(68188380);
    boolean passed = output == 16;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }


  public static void main(String[] args) {
    test1();
    test2();
    test4();
    test5();

    test3();

  }
}
