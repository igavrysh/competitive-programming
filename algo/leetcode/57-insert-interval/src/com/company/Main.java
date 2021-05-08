package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {
    int[][] input = {{1,3},{6,9}};
    int[] inputInsert = {2,5};
    Solution s = new Solution();
    int[][] output = s.insert(input, inputInsert);
    boolean passed = Arrays.deepEquals(output, new int[][]{{1,5},{6,9}});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] input = {{1,2},{3,5},{6,7},{8,10},{12,16}};
    int[] inputInsert = {4,8};
    Solution s = new Solution();
    int[][] output = s.insert(input, inputInsert);
    boolean passed = Arrays.deepEquals(output, new int[][]{{1,2},{3,10},{12,16}});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] input = {};
    int[] inputInsert = {5,7};
    Solution s = new Solution();
    int[][] output = s.insert(input, inputInsert);
    boolean passed = Arrays.deepEquals(output, new int[][]{{5,7}});
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[][] input = {{1,5}};
    int[] inputInsert = {2,3};
    Solution s = new Solution();
    int[][] output = s.insert(input, inputInsert);
    boolean passed = Arrays.deepEquals(output, new int[][]{{1,5}});
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[][] input = {{1,5}};
    int[] inputInsert = {2,7};
    Solution s = new Solution();
    int[][] output = s.insert(input, inputInsert);
    boolean passed = Arrays.deepEquals(output, new int[][]{{1,7}});
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    int[][] input = {{1,5}};
    int[] inputInsert = {6,8};
    Solution s = new Solution();
    int[][] output = s.insert(input, inputInsert);
    boolean passed = Arrays.deepEquals(output, new int[][]{{1,5}, {6,8}});
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
  }
}
