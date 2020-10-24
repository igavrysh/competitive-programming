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
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
