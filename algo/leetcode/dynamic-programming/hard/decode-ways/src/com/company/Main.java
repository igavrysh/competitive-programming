package com.company;

public class Main {

  private static void test1() {
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numDecodings("12");
    boolean passed = output == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numDecodings("226");
    boolean passed = output == 3;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numDecodings("0");
    boolean passed = output == 0;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numDecodings("");
    boolean passed = output == 1;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  private static void test5() {
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numDecodings("10");
    boolean passed = output == 1;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  private static void test6() {
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numDecodings("00");
    boolean passed = output == 0;
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }

  private static void test7() {
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numDecodings("01");
    boolean passed = output == 0;
    System.out.println("test7:" + (passed ? "passed" : "failed"));
  }

  private static void test8() {
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numDecodings("100");
    boolean passed = output == 0;
    System.out.println("test8:" + (passed ? "passed" : "failed"));
  }

  private static void test9() {
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numDecodings("101");
    boolean passed = output == 1;
    System.out.println("test9:" + (passed ? "passed" : "failed"));
  }

  private static void test10() {
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numDecodings("110");
    boolean passed = output == 1;
    System.out.println("test10:" + (passed ? "passed" : "failed"));
  }

  private static void test11() {
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numDecodings("1");
    boolean passed = output == 1;
    System.out.println("test11:" + (passed ? "passed" : "failed"));
  }

  private static void test21() {
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numDecodings("12");
    boolean passed = output == 2;
    System.out.println("test21:" + (passed ? "passed" : "failed"));
  }

  private static void test22() {
    SolutionIterative s = new SolutionIterative();
    int output = s.numDecodings("226");
    boolean passed = output == 3;
    System.out.println("test22:" + (passed ? "passed" : "failed"));
  }

  private static void test23() {
    SolutionIterative s = new SolutionIterative();
    int output = s.numDecodings("0");
    boolean passed = output == 0;
    System.out.println("test23:" + (passed ? "passed" : "failed"));
  }

  private static void test24() {
    SolutionIterative s = new SolutionIterative();
    int output = s.numDecodings("");
    boolean passed = output == 0;
    System.out.println("test24:" + (passed ? "passed" : "failed"));
  }

  private static void test25() {
    SolutionIterative s = new SolutionIterative();
    int output = s.numDecodings("10");
    boolean passed = output == 1;
    System.out.println("test25:" + (passed ? "passed" : "failed"));
  }

  private static void test26() {
    SolutionIterative s = new SolutionIterative();
    int output = s.numDecodings("00");
    boolean passed = output == 0;
    System.out.println("test26:" + (passed ? "passed" : "failed"));
  }

  private static void test27() {
    SolutionIterative s = new SolutionIterative();
    int output = s.numDecodings("01");
    boolean passed = output == 0;
    System.out.println("test27:" + (passed ? "passed" : "failed"));
  }

  private static void test28() {
    SolutionIterative s = new SolutionIterative();
    int output = s.numDecodings("100");
    boolean passed = output == 0;
    System.out.println("test28:" + (passed ? "passed" : "failed"));
  }

  private static void test29() {
    SolutionIterative s = new SolutionIterative();
    int output = s.numDecodings("101");
    boolean passed = output == 1;
    System.out.println("test29:" + (passed ? "passed" : "failed"));
  }

  private static void test30() {
    SolutionIterative s = new SolutionIterative();
    int output = s.numDecodings("110");
    boolean passed = output == 1;
    System.out.println("test30:" + (passed ? "passed" : "failed"));
  }

  private static void test31() {
    SolutionIterative s = new SolutionIterative();
    int output = s.numDecodings("1");
    boolean passed = output == 1;
    System.out.println("test31:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {

    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
    test8();
    test9();
    test10();
    test11();
    test21();
    test22();
    test23();

    test24();
    test25();



    test26();
    test27();
    test28();
    test29();
    test30();
    test31();


  }
}
