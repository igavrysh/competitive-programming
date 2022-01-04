package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {
    int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
    Solution s = new Solution();
    s.setZeroes(matrix);
    boolean passed = Arrays.deepEquals(matrix, new int[][]{{1,0,1},{0,0,0},{1,0,1}});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    Solution s = new Solution();
    s.setZeroes(matrix);
    boolean passed = Arrays.deepEquals(matrix, new int[][] {{0,0,0,0},{0,4,5,0},{0,3,1,0}});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] matrix = {{(int)(-1 * Math.pow(2, 31)),1,1},{1,0,1},{1,1,1}};
    Solution s = new Solution();
    s.setZeroes(matrix);
    boolean passed = Arrays.deepEquals(matrix, new int[][]{{(int)(-1 * Math.pow(2, 31)),0,1},{0,0,0},{1,0,1}});
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[][] matrix = {{1,0}};
    Solution s = new Solution();
    s.setZeroes(matrix);
    boolean passed = Arrays.deepEquals(matrix, new int[][]{{0, 0}});
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
