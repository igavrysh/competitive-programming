package com.company;

public class Main {

  public static void test1() {
    int[] nums = {3,2,1,5,6,4};
    Solution s = new Solution();
    int output = s.findKthLargest(nums,2);
    boolean passed = output == 5;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] nums = {3,2,3,1,2,4,5,5,6};
    Solution s = new Solution();
    int output = s.findKthLargest(nums,4);
    boolean passed = output == 4;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
