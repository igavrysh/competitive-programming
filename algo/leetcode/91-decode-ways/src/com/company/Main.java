package com.company;

public class Main {

  private static void test1() {
    Solution s = new Solution();
    int output = s.numDecodings("12");
    boolean passed = output == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    Solution s = new Solution();
    int output = s.numDecodings("226");
    boolean passed = output == 3;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    Solution s = new Solution();
    int output = s.numDecodings("0");
    boolean passed = output == 0;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    Solution s = new Solution();
    int output = s.numDecodings("");
    boolean passed = output == 1;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  private static void test5() {
    Solution s = new Solution();
    int output = s.numDecodings("10");
    boolean passed = output == 1;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  private static void test6() {
    Solution s = new Solution();
    int output = s.numDecodings("00");
    boolean passed = output == 0;
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }

  private static void test7() {
    Solution s = new Solution();
    int output = s.numDecodings("01");
    boolean passed = output == 0;
    System.out.println("test7:" + (passed ? "passed" : "failed"));
  }

  private static void test8() {
    Solution s = new Solution();
    int output = s.numDecodings("100");
    boolean passed = output == 0;
    System.out.println("test8:" + (passed ? "passed" : "failed"));
  }

  private static void test9() {
    Solution s = new Solution();
    int output = s.numDecodings("101");
    boolean passed = output == 1;
    System.out.println("test9:" + (passed ? "passed" : "failed"));
  }

  private static void test10() {
    Solution s = new Solution();
    int output = s.numDecodings("110");
    boolean passed = output == 1;
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
