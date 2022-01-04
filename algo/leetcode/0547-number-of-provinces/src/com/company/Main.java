package com.company;

public class Main {

  public static void test1() {
    int[][] input = {{1,1,0},{1,1,0},{0,0,1}};

    Solution s = new Solution();
    int output = s.findCircleNum(input);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] input = {{1,0,0},{0,1,0},{0,0,1}};

    Solution s = new Solution();
    int output = s.findCircleNum(input);
    boolean passed = output == 3;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void testDFS1() {
    int[][] input = {{1,1,0},{1,1,0},{0,0,1}};

    SolutionDFS s = new SolutionDFS();
    int output = s.findCircleNum(input);
    boolean passed = output == 2;
    System.out.println("testDFS1: " + (passed ? "passed" : "failed"));
  }

  public static void testDFS2() {
    int[][] input = {{1,0,0},{0,1,0},{0,0,1}};

    SolutionDFS s = new SolutionDFS();
    int output = s.findCircleNum(input);
    boolean passed = output == 3;
    System.out.println("testDFS2: " + (passed ? "passed" : "failed"));
  }

  public static void testBFS1() {
    int[][] input = {{1,1,0},{1,1,0},{0,0,1}};

    SolutionDFS s = new SolutionDFS();
    int output = s.findCircleNum(input);
    boolean passed = output == 2;
    System.out.println("testBFS1: " + (passed ? "passed" : "failed"));
  }

  public static void testBFS2() {
    int[][] input = {{1,0,0},{0,1,0},{0,0,1}};

    SolutionDFS s = new SolutionDFS();
    int output = s.findCircleNum(input);
    boolean passed = output == 3;
    System.out.println("testBFS2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();

    testDFS1();
    testDFS2();

    testBFS1();
    testBFS2();
  }
}
