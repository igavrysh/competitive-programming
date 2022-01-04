package com.company;

public class Main {

  public static void test1() {
    int[] nums1 = new int[]{3, 4, 6, 5};
    int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
    Solution solution = new Solution();
    int[] output = solution.maxNumber(nums1, nums2, 5);
    boolean passed = output.length == 5
        && output[0] == 9
        && output[1] == 8
        && output[2] == 6
        && output[3] == 5
        && output[4] == 3;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] nums1 = new int[]{6, 7};
    int[] nums2 = new int[]{6, 0, 4};
    Solution solution = new Solution();
    int[] output = solution.maxNumber(nums1, nums2, 5);
    boolean passed = output.length == 5
        && output[0] == 6
        && output[1] == 7
        && output[2] == 6
        && output[3] == 0
        && output[4] == 4;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] nums1 = new int[]{3, 9};
    int[] nums2 = new int[]{8, 9};
    Solution solution = new Solution();
    int[] output = solution.maxNumber(nums1, nums2, 3);
    boolean passed = output.length == 3
        && output[0] == 9
        && output[1] == 8
        && output[2] == 9;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
