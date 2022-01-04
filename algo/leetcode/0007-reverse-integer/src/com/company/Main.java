package com.company;

public class Main {

  private static void test1() {
    int input = 123;
    Solution s = new Solution();
    int output = s.reverse(input);
    boolean passed = output == 321;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    int input = -123;
    Solution s = new Solution();
    int output = s.reverse(input);
    boolean passed = output == -321;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    int input = -12;
    Solution s = new Solution();
    int output = s.reverse(input);
    boolean passed = output == -21;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    int input = 1534236469;
    Solution s = new Solution();
    int output = s.reverse(input);
    boolean passed = output == 0;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    //test1();
    //test2();
    //test3();
    test4();
  }
}
