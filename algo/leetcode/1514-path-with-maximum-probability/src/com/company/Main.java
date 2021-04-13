package com.company;

public class Main {

  public static void test1() {
    int n = 3;
    int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
    double[] succProb = {0.5, 0.5, 0.2};
    int start = 0;
    int end = 2;
    Solution s = new Solution();
    double output = s.maxProbability(n, edges, succProb, start, end);
    boolean passed = Math.abs(output - 0.25) < Math.pow(10, -5);
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int n = 3;
    int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
    double[] succProb = {0.5, 0.5, 0.3};
    int start = 0;
    int end = 2;
    Solution s = new Solution();
    double output = s.maxProbability(n, edges, succProb, start, end);
    boolean passed = Math.abs(output - 0.3) < Math.pow(10, -5);
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int n = 3;
    int[][] edges = {{0, 1}};
    double[] succProb = {0.5};
    int start = 0;
    int end = 2;
    Solution s = new Solution();
    double output = s.maxProbability(n, edges, succProb, start, end);
    boolean passed = Math.abs(output - 0.0) < Math.pow(10, -5);
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
