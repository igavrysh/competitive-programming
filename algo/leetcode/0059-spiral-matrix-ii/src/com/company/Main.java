package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int[][] output = s.generateMatrix(3);
    boolean passed = Arrays.deepEquals(
        output,
        new int[][]{{1,2,3},{8,9,4},{7,6,5}});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int[][] output = s.generateMatrix(1);
    boolean passed = Arrays.deepEquals(
        output,
        new int[][]{{1}});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    Solution2 s = new Solution2();
    int[][] output = s.generateMatrix(3);
    boolean passed = Arrays.deepEquals(
        output,
        new int[][]{{1,2,3},{8,9,4},{7,6,5}});
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    Solution2 s = new Solution2();
    int[][] output = s.generateMatrix(1);
    boolean passed = Arrays.deepEquals(
        output,
        new int[][]{{1}});
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test21() {
    Solution3 s = new Solution3();
    int[][] output = s.generateMatrix(3);
    boolean passed = Arrays.deepEquals(
        output,
        new int[][]{{1,2,3},{8,9,4},{7,6,5}});
    System.out.println("test21: " + (passed ? "passed" : "failed"));
  }

  public static void test22() {
    Solution3 s = new Solution3();
    int[][] output = s.generateMatrix(1);
    boolean passed = Arrays.deepEquals(
        output,
        new int[][]{{1}});
    System.out.println("test22: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test11();
    test12();
    test21();
    test22();
  }
}
