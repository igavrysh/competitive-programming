package com.company;

class Main {

  public static void test1() {
    int[] nums = {0,1};
    Solution s = new Solution();
    int output = s.findMaxLength(nums);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] nums = {0,1,0};
    Solution s = new Solution();
    int output = s.findMaxLength(nums);
    boolean passed = output == 2;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}