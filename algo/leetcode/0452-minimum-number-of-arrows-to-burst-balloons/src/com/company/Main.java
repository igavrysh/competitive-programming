package com.company;

public class Main {

  public static void test1() {
    int[][] points = {{10,16},{2,8},{1,6},{7,12}};
    Solution s = new Solution();
    int ouptut = s.findMinArrowShots(points);
    boolean passed = ouptut == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] points = {{1,2},{3,4},{5,6},{7,8}};
    Solution s = new Solution();
    int ouptut = s.findMinArrowShots(points);
    boolean passed = ouptut == 4;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] points = {{1,2},{2,3},{3,4},{4,5}};
    Solution s = new Solution();
    int ouptut = s.findMinArrowShots(points);
    boolean passed = ouptut == 2;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
