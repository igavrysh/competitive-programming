package com.company;

public class Main {

  public static String getMethodName() {
    return new Throwable()
        .getStackTrace()[1]
        .getMethodName();
  }

  public static void testBruteForce1() {
    SolutionBruteForce s = new SolutionBruteForce();
    int output = s.kthFactor(12, 3);
    boolean passed = output == 3;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testBruteForce2() {
    SolutionBruteForce s = new SolutionBruteForce();
    int output = s.kthFactor(7, 2);
    boolean passed = output == 7;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testBruteForce3() {
    SolutionBruteForce s = new SolutionBruteForce();
    int output = s.kthFactor(4, 4);
    boolean passed = output == -1;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    testBruteForce1();
    testBruteForce2();
    testBruteForce3();
  }
}
