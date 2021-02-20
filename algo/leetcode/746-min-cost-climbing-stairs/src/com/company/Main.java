package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.minCostClimbingStairs(new int[] {10, 15, 20});
    boolean passed = output == 15;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
    boolean passed = output == 6;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    int output = s.minCostClimbingStairs(new int[] {42});
    boolean passed = output == 0;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    int output = s.minCostClimbingStairs(new int[] {});
    boolean passed = output == 0;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    SolutionOptimized s = new SolutionOptimized();
    int output = s.minCostClimbingStairs(new int[] {10, 15, 20});
    boolean passed = output == 15;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    SolutionOptimized s = new SolutionOptimized();
    int output = s.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
    boolean passed = output == 6;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    SolutionOptimized s = new SolutionOptimized();
    int output = s.minCostClimbingStairs(new int[] {42});
    boolean passed = output == 0;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test8() {
    SolutionOptimized s = new SolutionOptimized();
    int output = s.minCostClimbingStairs(new int[] {});
    boolean passed = output == 0;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
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
  }
}
