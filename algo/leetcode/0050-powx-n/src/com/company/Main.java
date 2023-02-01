package com.company;

public class Main {

  public static void main(String[] args) {

    testFib();

    test01();
    test02();
    test03();
    test04();
    test05();
    test06();
    test07();
    test08();
    test09();

    test11();
    test12();
    test13();
    test14();
    test15();
    test16();
    test17();
    test21();
  }


  public static void testFib() {
    Fib fib = new Fib();
    int N = 1;
    N=1;
    fib.fib(N);
    System.out.println("N="+N + " T("+N+")=" + fib.T);
    N=2;
    fib.fib(N);
    System.out.println("N="+N + " T("+N+")=" + fib.T);
    N=4;
    fib.fib(N);
    System.out.println("N="+N + " T("+N+")=" + fib.T);
    N=5;
    fib.fib(N);
    System.out.println("N="+N + " T("+N+")=" + fib.T);
    N=8;
    fib.fib(N);
    System.out.println("N="+N + " T("+N+")=" + fib.T);
    N=10;
    fib.fib(N);
    System.out.println("N="+N + " T("+N+")=" + fib.T);
    N=20;
    fib.fib(N);
    System.out.println("N="+N + " T("+N+")=" + fib.T);
  }

  public static void test01() {
    SolutionPractice s = new SolutionPractice();
    double output = s.myPow(2.0, 10);
    boolean passed = output == 1024.0;
    System.out.println("test01: " + (passed ? "passed" : "failed"));
  }

  public static void test02() {
    SolutionPractice s = new SolutionPractice();
    double output = s.myPow(2.1, 3);
    boolean passed = Math.abs(output - 9.261) < Math.pow(10, -10);
    System.out.println("test02: " + (passed ? "passed" : "failed"));
  }

  public static void test03() {
    SolutionPractice s = new SolutionPractice();
    double output = s.myPow(2.0, -2);
    boolean passed = output == 0.25;
    System.out.println("test03: " + (passed ? "passed" : "failed"));
  }

  public static void test04() {
    SolutionPractice s = new SolutionPractice();
    double output = s.myPow(1.0, 2147483647);
    boolean passed = output == 1.0;
    System.out.println("test04: " + (passed ? "passed" : "failed"));
  }

  public static void test05() {
    SolutionPractice s = new SolutionPractice();
    double output = s.myPow(-1.0, 2);
    boolean passed = output == 1.0;
    System.out.println("test05: " + (passed ? "passed" : "failed"));
  }

  public static void test06() {
    SolutionPractice s = new SolutionPractice();
    double output = s.myPow(-1.0, 3);
    boolean passed = output == -1.0;
    System.out.println("test06: " + (passed ? "passed" : "failed"));
  }

  public static void test07() {
    SolutionPractice s = new SolutionPractice();
    double output = s.myPow(2.0, -2147483648);
    boolean passed = output == 0.0;
    System.out.println("test07: " + (passed ? "passed" : "failed"));
  }

  public static void test08() {
    SolutionPractice s = new SolutionPractice();
    double output = s.myPow(-1.0, -2147483648);
    boolean passed = output == 1;
    System.out.println("test08: " + (passed ? "passed" : "failed"));
  }

  public static void test09() {
    SolutionPractice s = new SolutionPractice();
    double output = s.myPow(-1.0, -2147483647);
    boolean passed = output == -1;
    System.out.println("test09: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(2.0, 10);
    boolean passed = output == 1024.0;
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(2.1, 3);
    boolean passed = Math.abs(output - 9.261) < Math.pow(10, -10);
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(2.0, -2);
    boolean passed = output == 0.25;
    System.out.println("test13: " + (passed ? "passed" : "failed"));
  }

  public static void test14() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(1.0, 2147483647);
    boolean passed = output == 1.0;
    System.out.println("test14: " + (passed ? "passed" : "failed"));
  }

  public static void test15() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(-1.0, 2);
    boolean passed = output == 1.0;
    System.out.println("test15: " + (passed ? "passed" : "failed"));
  }

  public static void test16() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(-1.0, 3);
    boolean passed = output == -1.0;
    System.out.println("test16: " + (passed ? "passed" : "failed"));
  }

  public static void test17() {
    SolutionOptimized s = new SolutionOptimized();
    double output = s.myPow(2.0, -2147483648);
    boolean passed = output == 0.0;
    System.out.println("test17: " + (passed ? "passed" : "failed"));
  }

  public static void test21() {
    SolutionOptimized2 s = new SolutionOptimized2();
    double output = s.myPow(2.0, 10);
    boolean passed = output == 1024.0;
    System.out.println("test21: " + (passed ? "passed" : "failed"));
  }
}
