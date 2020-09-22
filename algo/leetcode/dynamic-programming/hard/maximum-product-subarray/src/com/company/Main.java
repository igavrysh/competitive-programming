package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.maxProduct(new int[] { 2,3,-2,4 });
    boolean passed = output == 6;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.maxProduct(new int[] { -2,0,-1 });
    boolean passed = output == 0;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
