package com.company;

public class Main {

  public static void test1() {
    int[] nums = {1,2,3,4};
    int k = 5;
    Solution s = new Solution();
    int output = s.maxOperations(nums, k);
    boolean passed = output == 2;
    System.out.println("test1 " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] nums = {3,1,3,4,3};
    int k = 6;
    Solution s = new Solution();
    int output = s.maxOperations(nums, k);
    boolean passed = output == 1;
    System.out.println("test2 " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    int[] nums = {1,2,3,4};
    int k = 5;
    SolutionHashmap s = new SolutionHashmap();
    int output = s.maxOperations(nums, k);
    boolean passed = output == 2;
    System.out.println("test1 " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    int[] nums = {3,1,3,4,3};
    int k = 6;
    SolutionHashmap s = new SolutionHashmap();
    int output = s.maxOperations(nums, k);
    boolean passed = output == 1;
    System.out.println("test2 " + (passed ? "passed" : "failed"));
  }
  public static void main(String[] args) {
    test1();
    test2();
    test11();
    test12();
  }
}
