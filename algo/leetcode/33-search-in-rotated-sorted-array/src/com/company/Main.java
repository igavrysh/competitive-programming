package com.company;

public class Main {

  public static void test1() {
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int target = 0;
    Solution s = new Solution();
    int output = s.search(nums, target);
    boolean passed = output == 4;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int target = 3;
    Solution s = new Solution();
    int output = s.search(nums, target);
    boolean passed = output == -1;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] nums = {0};
    int target = 2;
    Solution s = new Solution();
    int output = s.search(nums, target);
    boolean passed = output == -1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] nums = {2};
    int target = 2;
    Solution s = new Solution();
    int output = s.search(nums, target);
    boolean passed = output == 0;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[] nums = { 1, 3};
    int target = 1;
    Solution s = new Solution();
    int output = s.search(nums, target);
    boolean passed = output == 0;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    int[] nums = { 3,4,5,6,1,2 };
    int target = 2;
    Solution s = new Solution();
    int output = s.search(nums, target);
    boolean passed = output == 5;
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
  }
}
