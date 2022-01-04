package com.company;

public class Main {

  public static void test1() {
    int[][] board = {
        {-1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, 35, -1, -1, 13, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, 15, -1, -1, -1, -1}
    };
    Solution s = new Solution();
    int output = s.snakesAndLadders(board);
    boolean passed = output == 4;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] board = {
        {-1, -1},
        {-1, 3}
    };
    Solution s = new Solution();
    int output = s.snakesAndLadders(board);
    boolean passed = output == 1;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] board = {
        {-1, -1, -1, -1, -1, -1},
        { 1,  2,  3,  4,  5,  6},
        {-1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1}
    };
    Solution s = new Solution();
    int output = s.snakesAndLadders(board);
    boolean passed = output == -1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
