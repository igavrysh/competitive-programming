package com.company;

public class Main {

  public static void test1() {
    int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
    Solution s = new Solution();
    int output = s.cherryPickup(grid);
    boolean passed = output == 24;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] grid = {{1,0,0,0,0,0,1},{2,0,0,0,0,3,0},{2,0,9,0,0,0,0},{0,3,0,5,4,0,0},{1,0,2,3,0,0,6}};
    Solution s = new Solution();
    int output = s.cherryPickup(grid);
    boolean passed = output == 28;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] grid = {{0,8,7,10,9,10,0,9,6},{8,7,10,8,7,4,9,6,10},{8,1,1,5,1,5,5,1,2},{9,4,10,8,8,1,9,5,0},{4,3,6,10,9,2,4,8,10},{7,3,2,8,3,3,5,9,8},{1,2,6,5,6,2,0,10,0}};
    Solution s = new Solution();
    int output = s.cherryPickup(grid);
    boolean passed = output == 96;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
