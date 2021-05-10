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

  public static void main(String[] args) {
    test1();
    test2();
  }
}
