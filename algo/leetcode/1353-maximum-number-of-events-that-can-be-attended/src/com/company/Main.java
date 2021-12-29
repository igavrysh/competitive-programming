package com.company;

public class Main {

  public static void test1() {
    int[][] input = {{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 7;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] input = {{1,2},{2,3},{3,4},{1,2}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 4;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] input = {{1,2},{2,3},{3,4}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 3;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[][] input = {{1,2},{1,2},{3,3},{1,5},{1,5}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 5;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[][] input = {{1,5},{1,5},{1,5},{2,3},{2,3}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 5;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }
}
