package com.company;

public class Main {

  public static void test1() {
    int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
    Solution s = new Solution();
    int output = s.minPathSum(grid);
    boolean passed = output == 7;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] grid = {{1,2,3},{4,5,6}};
    Solution s = new Solution();
    int output = s.minPathSum(grid);
    boolean passed = output == 12;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
