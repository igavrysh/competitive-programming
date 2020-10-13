package com.company;

public class Main {

  private static void test1() {
    int[] height = { 1, 1};
    Solution s = new Solution();
    int output = s.maxArea(height);
    boolean passed = output == 1;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    int[] height = { 4, 3, 2, 1, 4 };
    Solution s = new Solution();
    int output = s.maxArea(height);
    boolean passed = output == 16;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    int[] height = { 1, 2, 1 };
    Solution s = new Solution();
    int output = s.maxArea(height);
    boolean passed = output == 2;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
