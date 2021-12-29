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

  public static void testHeap1() {
    SolutionHeap s = new SolutionHeap();
    int output = s.kthFactor(12, 3);
    boolean passed = output == 3;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testHeap2() {
    SolutionHeap s = new SolutionHeap();
    int output = s.kthFactor(7, 2);
    boolean passed = output == 7;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testHeap3() {
    SolutionHeap s = new SolutionHeap();
    int output = s.kthFactor(4, 4);
    boolean passed = output == -1;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testHeap4() {
    SolutionHeap s = new SolutionHeap();
    int output = s.kthFactor(1, 1);
    boolean passed = output == 1;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testMath1() {
    SolutionMath s = new SolutionMath();
    int output = s.kthFactor(12, 3);
    boolean passed = output == 3;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testMath2() {
    SolutionMath s = new SolutionMath();
    int output = s.kthFactor(7, 2);
    boolean passed = output == 7;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testMath3() {
    SolutionMath s = new SolutionMath();
    int output = s.kthFactor(4, 4);
    boolean passed = output == -1;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testMath4() {
    SolutionMath s = new SolutionMath();
    int output = s.kthFactor(1, 1);
    boolean passed = output == 1;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    testBruteForce1();
    testBruteForce2();
    testBruteForce3();

    testHeap1();
    testHeap2();
    testHeap3();
    testHeap4();

    testMath1();
    testMath2();
    testMath3();
    testMath4();
  }
}
