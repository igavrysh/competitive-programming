package com.company;

public class Main {

  public static void test1() {
    int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
    Solution s = new Solution();
    int output = s.minCost(costs);
    boolean passed = output == 10;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] costs = {{7,6,2}};
    Solution s = new Solution();
    int output = s.minCost(costs);
    boolean passed = output == 2;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
