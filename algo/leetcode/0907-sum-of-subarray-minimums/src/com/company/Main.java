package com.company;

public class Main {

  public static void test1() {
    int[] input = {3,1,2,4};
    Solution s = new Solution();
    int output = s.sumSubarrayMins(input);
    boolean passed = output == 17;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {11,81,94,43,3};
    Solution s = new Solution();
    int output = s.sumSubarrayMins(input);
    boolean passed = output == 444;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
