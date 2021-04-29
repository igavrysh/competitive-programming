package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    double output = s.myPow(2.0, 10);
    boolean passed = output == 1024.0;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    double output = s.myPow(2.1, 3);
    boolean passed = Math.abs(output - 9.261) < Math.pow(10, -10);
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    double output = s.myPow(2.0, -2);
    boolean passed = output == 0.25;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    double output = s.myPow(1.0, 2147483647);
    boolean passed = output == 1.0;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    Solution s = new Solution();
    double output = s.myPow(-1.0, 2);
    boolean passed = output == 1.0;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    Solution s = new Solution();
    double output = s.myPow(-1.0, 3);
    boolean passed = output == -1.0;
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    Solution s = new Solution();
    double output = s.myPow(2.0, -2147483648);
    boolean passed = output == 0.0;
    System.out.println("test7: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    /*
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();

     */
    test7();
  }
}
