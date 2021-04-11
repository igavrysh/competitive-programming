package com.company;

public class Main {

  public static void test1() {
    int[][] heights = new int[][] {{1,2,2},{3,8,2},{5,3,5}};
    Solution s = new Solution();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] heights = new int[][] {{2}};
    Solution s = new Solution();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 0;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] heights = new int[][] {
        {4,   3,  4,  10, 5,  5,  9,  2},
        {10,  8,  2,  10, 9,  7,  5,  6},
        {5,   8,  10, 10, 10, 7,  4,  2},
        {5,   1,  3,  1,  1,  3,  1,  9},
        {6,   4,  10, 6,  10, 9,  4,  6}};
    Solution s = new Solution();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 5;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[][] heights = new int[][] {
        {4, 2,  3},
        {5, 4,  1},
        {7, 3,  4},
        {1, 2,  5},
        {6, 1,  3},
        {5, 2,  4}};

    Solution s = new Solution();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 2;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[][] heights = new int[][] {
        {1, 1000000}};


    Solution s = new Solution();
    int output = s.minimumEffortPath(heights);
    boolean passed = output == 999999;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }
}
