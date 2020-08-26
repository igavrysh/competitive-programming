package com.company;

import java.util.List;

public class Main {

  private static void test1() {
    int[] comb = new int[]{2, 3, 6, 7};
    Solution solution = new Solution();
    List<List<Integer>> output = solution.combinationSum(comb, 7);
    boolean passed = output.size() == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    int[] comb = new int[]{2, 3};
    Solution solution = new Solution();
    List<List<Integer>> output = solution.combinationSum(comb, 7);
    boolean passed = output.size() == 1;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    int[] comb = new int[]{1, 2};
    Solution solution = new Solution();
    List<List<Integer>> output = solution.combinationSum(comb, 4);
    boolean passed = output.size() == 3;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    //test1();
    //test2();
    test3();
  }
}
