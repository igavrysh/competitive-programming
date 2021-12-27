package com.company;

public class Main {

  public static String getMethodName() {
    return new Throwable()
        .getStackTrace()[1]
        .getMethodName();

  }

  public static void testBruteForce1() {
    int[] nums = {1,2,1,2,3};
    int k = 2;
    SolutionBruteForce s = new SolutionBruteForce();
    int output = s.subarraysWithKDistinct(nums, k);
    boolean passed = output == 7;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testBruteForce2() {
    int[] nums = {1,2,1,3,4};
    int k = 3;
    SolutionBruteForce s = new SolutionBruteForce();
    int output = s.subarraysWithKDistinct(nums, k);
    boolean passed = output == 3;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    testBruteForce1();
    testBruteForce2();
  }
}
