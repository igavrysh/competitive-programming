package com.company;

public class Main {

  public static void test01() {
    Solution s = new Solution();
    double output = s.myPow(2.0, 10);
    boolean passed = output == 1024.0;
    System.out.println("test01: " + (passed ? "passed" : "failed"));
  }

  public static void test02() {
    Solution s = new Solution();
    double output = s.myPow(2.1, 3);
    boolean passed = Math.abs(output - 9.261) < Math.pow(10, -10);
    System.out.println("test02: " + (passed ? "passed" : "failed"));
  }

  public static void test03() {
    Solution s = new Solution();
    double output = s.myPow(2.0, -2);
    boolean passed = output == 0.25;
    System.out.println("test03: " + (passed ? "passed" : "failed"));
  }

  public static void test04() {
    Solution s = new Solution();
    double output = s.myPow(1.0, 2147483647);
    boolean passed = output == 1.0;
    System.out.println("test04: " + (passed ? "passed" : "failed"));
  }

  public static void test05() {
    Solution s = new Solution();
    double output = s.myPow(-1.0, 2);
    boolean passed = output == 1.0;
    System.out.println("test05: " + (passed ? "passed" : "failed"));
  }

  public static void test06() {
    Solution s = new Solution();
    double output = s.myPow(-1.0, 3);
    boolean passed = output == -1.0;
    System.out.println("test06: " + (passed ? "passed" : "failed"));
  }

  public static void test07() {
    Solution s = new Solution();
    double output = s.myPow(2.0, -2147483648);
    boolean passed = output == 0.0;
    System.out.println("test07: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(2.0, 10);
    boolean passed = output == 1024.0;
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(2.1, 3);
    boolean passed = Math.abs(output - 9.261) < Math.pow(10, -10);
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(2.0, -2);
    boolean passed = output == 0.25;
    System.out.println("test13: " + (passed ? "passed" : "failed"));
  }

  public static void test14() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(1.0, 2147483647);
    boolean passed = output == 1.0;
    System.out.println("test14: " + (passed ? "passed" : "failed"));
  }

  public static void test15() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(-1.0, 2);
    boolean passed = output == 1.0;
    System.out.println("test15: " + (passed ? "passed" : "failed"));
  }

  public static void test16() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(-1.0, 3);
    boolean passed = output == -1.0;
    System.out.println("test16: " + (passed ? "passed" : "failed"));
  }

  public static void test17() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(2.0, -2147483648);
    boolean passed = output == 0.0;
    System.out.println("test17: " + (passed ? "passed" : "failed"));
  }

  public static void test21() {
    SolutionOptimized2 s = new SolutionOptimized2();
    double output = s.myPow(2.0, 10);
    boolean passed = output == 1024.0;
    System.out.println("test21: " + (passed ? "passed" : "failed"));
  }


  public static void main(String[] args) {
    test01();
    test02();
    test03();
    test04();
    test05();
    test06();
    test07();
    test11();
    test12();
    test13();
    test14();
    test15();
    test16();
    test17();
    test21();
  }
}
