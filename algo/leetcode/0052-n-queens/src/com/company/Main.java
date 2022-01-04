package com.company;

public class Main {

  private static void test1() {
    Solution s = new Solution();
    int output = s.totalNQueens(1);
    boolean passed = output == 1;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    Solution s = new Solution();
    int output = s.totalNQueens(2);
    boolean passed = output == 0;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    Solution s = new Solution();
    int output = s.totalNQueens(3);
    boolean passed = output == 0;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    Solution s = new Solution();
    int output = s.totalNQueens(4);
    boolean passed = output == 2;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  private static void test8() {
    Solution s = new Solution();
    int output = s.totalNQueens(8);
    boolean passed = output == 92;
    System.out.println("test8: " + (passed ? "passed" : "failed"));
  }

  private static void test9() {
    Solution s = new Solution();
    int output = s.totalNQueens(9);
    boolean passed = output == 352;
    System.out.println("test9: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test8();
    test9();
  }

}
