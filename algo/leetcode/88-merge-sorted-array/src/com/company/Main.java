package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {;
    int[] nums1 = {1,2,3,0,0,0};
    int m = 3;
    int[] nums2 = {2,5,6};
    int n = 3;
    Solution s = new Solution();
    s.merge(nums1, m, nums2, n);
    boolean passed = Arrays.equals(nums1, new int[] {1,2,2,3,5,6});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] nums1 = {1};
    int m = 1;
    int[] nums2 = {};
    int n = 0;
    Solution s = new Solution();
    s.merge(nums1, m, nums2, n);
    boolean passed = Arrays.equals(nums1, new int[] {1});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] nums1 = {0};
    int m = 0;
    int[] nums2 = {1};
    int n = 1;
    Solution s = new Solution();
    s.merge(nums1, m, nums2, n);
    boolean passed = Arrays.equals(nums1, new int[] {1});
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
