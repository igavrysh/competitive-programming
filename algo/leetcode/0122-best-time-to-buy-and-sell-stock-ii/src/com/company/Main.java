package com.company;

public class Main {

  private static void test1() {
    SolutionDP s = new SolutionDP();
    int output = s.maxProfit(new int[] { 7,1,5,3,6,4 });
    boolean passed = output == 7;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    SolutionDP s = new SolutionDP();
    int output = s.maxProfit(new int[] { 1,2,3,4,5 });
    boolean passed = output == 4;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    SolutionDP s = new SolutionDP();
    int output = s.maxProfit(new int[] { 7,6,4,3,1 });
    boolean passed = output == 0;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    SolutionDP s = new SolutionDP();
    int output = s.maxProfit(new int[] { 7,1,5,3,6,4 });
    boolean passed = output == 7;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  private static void test5() {
    SolutionDP s = new SolutionDP();
    int output = s.maxProfit(new int[] { 2,1,4});
    boolean passed = output == 3;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }
}
