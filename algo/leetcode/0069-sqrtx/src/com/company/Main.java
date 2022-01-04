package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.mySqrt(4);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.mySqrt(0);
    boolean passed = output == 0;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    int output = s.mySqrt(1);
    boolean passed = output == 1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    int output = s.mySqrt(8);
    boolean passed = output == 2;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    Solution s = new Solution();
    int output = s.mySqrt(2147395599);
    boolean passed = output == 46339;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    Solution s = new Solution();
    int output = s.mySqrt((int)Math.pow(2, 31)-1);
    boolean passed = output == 46340;
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    Solution2 s = new Solution2();
    int output = s.mySqrt(4);
    boolean passed = output == 2;
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    Solution2 s = new Solution2();
    int output = s.mySqrt(0);
    boolean passed = output == 0;
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    Solution2 s = new Solution2();
    int output = s.mySqrt(1);
    boolean passed = output == 1;
    System.out.println("test13: " + (passed ? "passed" : "failed"));
  }

  public static void test14() {
    Solution2 s = new Solution2();
    int output = s.mySqrt(8);
    boolean passed = output == 2;
    System.out.println("test14: " + (passed ? "passed" : "failed"));
  }

  public static void test15() {
    Solution2 s = new Solution2();
    int output = s.mySqrt(2147395599);
    boolean passed = output == 46339;
    System.out.println("test15: " + (passed ? "passed" : "failed"));
  }

  public static void test16() {
    Solution2 s = new Solution2();
    int output = s.mySqrt((int)Math.pow(2, 31)-1);
    boolean passed = output == 46340;
    System.out.println("test16: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test11();
    test12();
    test13();
    test14();
    test15();
    test16();
  }
}
