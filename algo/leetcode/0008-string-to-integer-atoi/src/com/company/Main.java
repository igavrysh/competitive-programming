package com.company;

public class Main {

  private static void test1() {
    String input = "42";
    Solution s = new Solution();
    int output = s.myAtoi(input);
    boolean passed = output == 42;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    String input = "-42";
    Solution s = new Solution();
    int output = s.myAtoi(input);
    boolean passed = output == -42;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    String input = "4193 with words";
    Solution s = new Solution();
    int output = s.myAtoi(input);
    boolean passed = output == 4193;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    String input = "words and 987";
    Solution s = new Solution();
    int output = s.myAtoi(input);
    boolean passed = output == 0;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  private static void test5() {
    String input = "-91283472332";
    Solution s = new Solution();
    int output = s.myAtoi(input);
    boolean passed = output == -2147483648;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  private static void test6() {
    String input = "+1";
    Solution s = new Solution();
    int output = s.myAtoi(input);
    boolean passed = output == 1;
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }

  private static void test7() {
    String input = "+-12";
    Solution s = new Solution();
    int output = s.myAtoi(input);
    boolean passed = output == 0;
    System.out.println("test7:" + (passed ? "passed" : "failed"));
  }

  private static void test8() {
    String input = "21474836460";
    Solution s = new Solution();
    int output = s.myAtoi(input);
    boolean passed = output == 2147483647;
    System.out.println("test8:" + (passed ? "passed" : "failed"));
  }

  private static void test9() {
    String input = "   +0 123";
    Solution s = new Solution();
    int output = s.myAtoi(input);
    boolean passed = output == 0;
    System.out.println("test9:" + (passed ? "passed" : "failed"));
  }

  private static void test10() {
    String input = "   +";
    Solution s = new Solution();
    int output = s.myAtoi(input);
    boolean passed = output == 0;
    System.out.println("test10:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
    test8();
    test9();
    test10();
  }
}
