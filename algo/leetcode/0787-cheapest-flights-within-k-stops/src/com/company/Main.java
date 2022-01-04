package com.company;

public class Main {
  /*
  Input:
  n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
  src = 0, dst = 2, k = 1
  Output: 200
   */
  public static void test1() {
    int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
    Solution s = new Solution();
    int output = s.findCheapestPrice(3, edges, 0, 2, 1);
    boolean passed = output == 200;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
    Solution s = new Solution();
    int output = s.findCheapestPrice(3, edges, 0, 2, 0);
    boolean passed = output == 500;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] edges = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
    Solution s = new Solution();
    int output = s.findCheapestPrice(4, edges, 0, 3, 1);
    boolean passed = output == 6;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
