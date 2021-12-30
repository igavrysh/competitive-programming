package com.company;

public class Main {

  public static void test1() {
    int[] inventory = {2,5};
    int orders = 4;
    Solution s = new Solution();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 14;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] inventory = {3,5};
    int orders = 6;
    Solution s = new Solution();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 19;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
