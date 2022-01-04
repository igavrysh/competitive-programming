package com.company;

public class Main {

  private static void test1() {
    int[] input = {2,3,1,2,4,3};
    Solution s = new Solution();
    int output = s.minSubArrayLen(7, input);
    boolean passed = output == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    int[] input = {1};
    Solution s = new Solution();
    int output = s.minSubArrayLen(42, input);
    boolean passed = output == 0;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    int[] input = {42};
    Solution s = new Solution();
    int output = s.minSubArrayLen(1, input);
    boolean passed = output == 1;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
