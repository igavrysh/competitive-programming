package com.company;

public class Main {

  public static void test1() {
    int[][] input = {{0,0,0},{0,1,0},{0,0,0}};
    Solution s = new Solution();
    int output = s.uniquePathsWithObstacles(input);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] input = {{0,1},{0,0}};
    Solution s = new Solution();
    int output = s.uniquePathsWithObstacles(input);
    boolean passed = output == 1;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] input = {{1}};
    Solution s = new Solution();
    int output = s.uniquePathsWithObstacles(input);
    boolean passed = output == 0;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    int[][] input = {{0,0,0},{0,1,0},{0,0,0}};
    Solution2 s = new Solution2();
    int output = s.uniquePathsWithObstacles(input);
    boolean passed = output == 2;
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    int[][] input = {{0,1},{0,0}};
    Solution2 s = new Solution2();
    int output = s.uniquePathsWithObstacles(input);
    boolean passed = output == 1;
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    int[][] input = {{1}};
    Solution2 s = new Solution2();
    int output = s.uniquePathsWithObstacles(input);
    boolean passed = output == 0;
    System.out.println("test13: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test11();
    test12();
    test13();
  }
}
