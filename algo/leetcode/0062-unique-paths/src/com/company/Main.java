package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.uniquePaths(3, 7);
    boolean passed = output == 28;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.uniquePaths(2, 3);
    boolean passed = output == 3;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    int output = s.uniquePaths(7, 3);
    boolean passed = output == 28;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    int output = s.uniquePaths(3, 3);
    boolean passed = output == 6;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
