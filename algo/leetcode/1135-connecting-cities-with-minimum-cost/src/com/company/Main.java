package com.company;

public class Main {

  public static void test1() {
    int n = 3;
    int[][] connections = {{1,2,5},{1,3,6},{2,3,1}};
    Solution s = new Solution();
    int output = s.minimumCost(n, connections);
    boolean passed = output == 6;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int n = 4;
    int[][] connections = {{1,2,3},{3,4,4}};
    Solution s = new Solution();
    int output = s.minimumCost(n, connections);
    boolean passed = output == -1;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
