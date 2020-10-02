package com.company;

public class Main {

  public static void test1() {
    SolutionIterative s = new SolutionIterative();
    int output = s.numSquares(12);
    boolean passed = output == 3;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    SolutionIterative s = new SolutionIterative();
    int output = s.numSquares(13);
    boolean passed = output == 2;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    SolutionIterative s = new SolutionIterative();
    int output = s.numSquares(51);
    boolean passed = output == 3;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
