package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    int[] nums = {1,0,-1,0,-2,2};
    Solution s = new Solution();
    List<List<Integer>> output = s.fourSum(nums, 0);
    boolean passed = output.size() == 3
        && output.contains(Arrays.asList(new Integer[] {-2,-1,1,2}))
        && output.contains(Arrays.asList(new Integer[] {-2,0,0,2}))
        && output.contains(Arrays.asList(new Integer[] {-1,0,0,1}));
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] nums = {};
    Solution s = new Solution();
    List<List<Integer>> output = s.fourSum(nums, 0);
    boolean passed = output.size() == 0;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int [] nums = {0, 0, 0, 0};
    Solution s = new Solution();
    List<List<Integer>> output = s.fourSum(nums, 0);
    boolean passed = output.size() == 1
        && output.contains(Arrays.asList(new Integer[] {0,0,0,0}));
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int [] nums = {-2,-1,-1,1,1,2,2};
    Solution s = new Solution();
    List<List<Integer>> output = s.fourSum(nums, 0);
    boolean passed = output.size() == 2
        && output.contains(Arrays.asList(new Integer[] {-2,-1,1,2}))
        && output.contains(Arrays.asList(new Integer[] {-1,-1,1,1}));
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[] nums = {1, 1, 2, 2};
    Solution s = new Solution();
    List<List<Integer>> output = s.twoSum(nums, 0, 3);
    boolean passed = output.size() == 1
        && output.contains(Arrays.asList(new Integer[] {1, 2}));
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    int[] nums = {1, 1, 3};
    Solution s = new Solution();
    List<List<Integer>> output = s.twoSum(nums, 0, 2);
    boolean passed = output.size() == 1
        && output.contains(Arrays.asList(new Integer[] {1, 1}));
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    int[] nums = {0,2,2,2,10,-3,-9,2,-10,-4,-9,-2,2,8,7};
    Solution s = new Solution();
    List<List<Integer>> output = s.fourSum(nums, 6);
    boolean passed = output.size() == 8
        && output.contains(Arrays.asList(new Integer[] {-10,-2,8,10}))
        && output.contains(Arrays.asList(new Integer[] {-9,-3,8,10}))
        && output.contains(Arrays.asList(new Integer[] {-9,-2,7,10}))
        && output.contains(Arrays.asList(new Integer[] {-9,0,7,8}))
        && output.contains(Arrays.asList(new Integer[] {-4,-2,2,10}))
        && output.contains(Arrays.asList(new Integer[] {-4,0,2,8}))
        && output.contains(Arrays.asList(new Integer[] {-3,0,2,7}))
        && output.contains(Arrays.asList(new Integer[] {0,2,2,2}));
    System.out.println("test7:" + (passed ? "passed" : "failed"));
  }

  public static void test8() {
    int[] nums = {0, 2, 2, 2, 2, 2, 7, 8, 10};
    Solution s = new Solution();
    List<List<Integer>> output = s.fourSum(nums, 6);
    boolean passed = output.size() == 1
        && output.contains(Arrays.asList(new Integer[] {0, 2, 2, 2}));
    System.out.println("test8:" + (passed ? "passed" : "failed"));
  }

  public static void test9() {
    int[] nums = {2, 2, 2};
    Solution s = new Solution();
    List<List<Integer>> output = s.twoSum(nums, 0, 4);
    boolean passed = output.size() == 1
        && output.contains(Arrays.asList(new Integer[] {2, 2}));
    System.out.println("test9:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
    test8();
    test9();
  }
}
