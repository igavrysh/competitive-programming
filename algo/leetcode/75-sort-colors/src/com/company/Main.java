package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {
    int[] nums = {2,0,2,1,1,0};
    Solution s = new Solution();
    s.sortColors(nums);
    boolean passed = Arrays.equals(nums, new int[]{0,0,1,1,2,2});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] nums = {2,0,1};
    Solution s = new Solution();
    s.sortColors(nums);
    boolean passed = Arrays.equals(nums, new int[]{0,1,2});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] nums = {0};
    Solution s = new Solution();
    s.sortColors(nums);
    boolean passed = Arrays.equals(nums, new int[]{0});
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] nums = {1};
    Solution s = new Solution();
    s.sortColors(nums);
    boolean passed = Arrays.equals(nums, new int[]{1});
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test21() {
    int[] nums = {2,0,2,1,1,0};
    Solution2 s = new Solution2();
    s.sortColors(nums);
    boolean passed = Arrays.equals(nums, new int[]{0,0,1,1,2,2});
    System.out.println("test21: " + (passed ? "passed" : "failed"));
  }

  public static void test22() {
    int[] nums = {2,0,1};
    Solution2 s = new Solution2();
    s.sortColors(nums);
    boolean passed = Arrays.equals(nums, new int[]{0,1,2});
    System.out.println("test22: " + (passed ? "passed" : "failed"));
  }

  public static void test23() {
    int[] nums = {0};
    Solution2 s = new Solution2();
    s.sortColors(nums);
    boolean passed = Arrays.equals(nums, new int[]{0});
    System.out.println("test23: " + (passed ? "passed" : "failed"));
  }

  public static void test24() {
    int[] nums = {1};
    Solution2 s = new Solution2();
    s.sortColors(nums);
    boolean passed = Arrays.equals(nums, new int[]{1});
    System.out.println("test24: " + (passed ? "passed" : "failed"));
  }

  public static void test31() {
    int[] nums = {2,0,2,1,1,0};
    Solution3 s = new Solution3();
    s.sortColors(nums);
    boolean passed = Arrays.equals(nums, new int[]{0,0,1,1,2,2});
    System.out.println("test31: " + (passed ? "passed" : "failed"));
  }

  public static void test32() {
    int[] nums = {2,0,1};
    Solution3 s = new Solution3();
    s.sortColors(nums);
    boolean passed = Arrays.equals(nums, new int[]{0,1,2});
    System.out.println("test32: " + (passed ? "passed" : "failed"));
  }

  public static void test33() {
    int[] nums = {0};
    Solution3 s = new Solution3();
    s.sortColors(nums);
    boolean passed = Arrays.equals(nums, new int[]{0});
    System.out.println("test33: " + (passed ? "passed" : "failed"));
  }

  public static void test34() {
    int[] nums = {1};
    Solution3 s = new Solution3();
    s.sortColors(nums);
    boolean passed = Arrays.equals(nums, new int[]{1});
    System.out.println("test34: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test21();
    test22();
    test23();
    test24();
    test31();
    test32();
    test33();
    test34();
  }
}
