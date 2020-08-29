package com.company;

public class Main {

  private static void test1() {
    Solution solution = new Solution();
    int output = solution.coinChange(new int[]{1, 2, 5}, 11);
    System.out.println("output:" + Integer.toString(output));
    boolean passed = output == 3;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
