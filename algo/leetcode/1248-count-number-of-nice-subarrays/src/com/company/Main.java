package com.company;

public class Main {

  public static void test1() {
    int[] nums = {1,1,2,1,1};
    int k = 3;
    Solution s = new Solution();
    int output = s.numberOfSubarrays(nums, k);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] nums = {2,2,2,1,2,2,1,2,2,2};
    int k = 2;
    Solution s = new Solution();
    int output = s.numberOfSubarrays(nums, k);
    boolean passed = output == 16;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
