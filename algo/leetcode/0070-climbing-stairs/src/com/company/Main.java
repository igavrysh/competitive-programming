package com.company;

public class Main {

  private static void test1() {
    SolutionInefficient solution = new SolutionInefficient();
    int output = solution.climbStairs(2);
    boolean passed = output == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    SolutionInefficient solution = new SolutionInefficient();
    int output = solution.climbStairs(3);
    boolean passed = output == 3;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    SolutionInefficient solution = new SolutionInefficient();
    int output = solution.climbStairs(4);
    boolean passed = output == 5;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    SolutionInefficient solution = new SolutionInefficient();
    int output = solution.climbStairs(5);
    boolean passed = output == 8;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
