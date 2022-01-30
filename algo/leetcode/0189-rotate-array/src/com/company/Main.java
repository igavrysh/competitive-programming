package com.company;

import java.util.Arrays;

class Main {
  
  public static void testSolution1() {
    int[] nums = {1,2,3,4,5,6,7};
    int k = 3;
    Solution s = new Solution();
    s.rotate(nums, k);
    boolean passed = Arrays.equals(nums, new int[]{5,6,7,1,2,3,4});
    System.out.println("testSolution1: " + (passed ? "passed" : "failed") );
  }

  public static void testSolutionFaster1() {
    int[] nums = {1,2,3,4,5,6,7};
    int k = 3;
    SolutionFaster s = new SolutionFaster();
    s.rotate(nums, k);
    boolean passed = Arrays.equals(nums, new int[]{5,6,7,1,2,3,4});
    System.out.println("testSolutionFaster1: " + (passed ? "passed" : "failed") );
  }

  public static void testSolutionFaster2() {
    int[] nums = {1,2,3,4,5,6};
    int k = 3;
    SolutionFaster s = new SolutionFaster();
    s.rotate(nums, k);
    boolean passed = Arrays.equals(nums, new int[]{4,5,6,1,2,3});
    System.out.println("testSolutionFaster2: " + (passed ? "passed" : "failed") );
  }

  public static void testSolutionFaster3() {
    int[] nums = {-1,-100,3,99};
    int k = 3;
    SolutionFaster s = new SolutionFaster();
    s.rotate(nums, k);
    boolean passed = Arrays.equals(nums, new int[]{-100,3,99,-1});
    System.out.println("testSolutionFaster3: " + (passed ? "passed" : "failed") );
  }

  public static void main(String[] args) {
    testSolution1();
    testSolutionFaster1();
    testSolutionFaster2();
    testSolutionFaster3();
  }
}