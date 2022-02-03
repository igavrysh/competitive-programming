package com.company;

public class Main {

  public static void test1() {
    int[] nums1 = new int[]{1,2}, nums2 = new int[]{-2,-1}, 
      nums3 = new int[]{-1,2}, nums4 = new int[]{0,2};
    Solution s = new Solution();
    int output = s.fourSumCount(nums1, nums2, nums3, nums4);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] nums1 = new int[]{0}, nums2 = new int[]{0}, 
      nums3 = new int[]{0}, nums4 = new int[]{0};
    Solution s = new Solution();
    int output = s.fourSumCount(nums1, nums2, nums3, nums4);
    boolean passed = output == 1;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] nums1 = {-1,-1}, nums2 = {-1,1}, nums3 = {-1,1}, nums4 = {1,-1};
    Solution s = new Solution();
    int output = s.fourSumCount(nums1, nums2, nums3, nums4);
    boolean passed = output == 6;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void testSolutionKSum1() {
    int[] nums1 = new int[]{1,2}, nums2 = new int[]{-2,-1}, 
      nums3 = new int[]{-1,2}, nums4 = new int[]{0,2};
    SolutionKSum s = new SolutionKSum();
    int output = s.fourSumCount(nums1, nums2, nums3, nums4);
    boolean passed = output == 2;
    System.out.println("testSolutionKSum1: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    testSolutionKSum1();
  }
  
}
