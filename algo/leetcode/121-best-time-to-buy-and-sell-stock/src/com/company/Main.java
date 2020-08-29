package com.company;

public class Main {

  public static void test1() {
    Solution solution = new Solution();
    int output = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    boolean passed = output == 5;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution solution = new Solution();
    boolean passed = solution.maxProfit(new int[]{7, 6, 4, 3, 1}) == 0;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
