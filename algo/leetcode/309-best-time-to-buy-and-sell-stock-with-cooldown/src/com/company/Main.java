package com.company;

public class Main {

  public static void test1() {
    SolutionDPIncr s = new SolutionDPIncr();
    int output = s.maxProfit(new int[] {1,2,3,0,2});
    boolean passed = output ==  3;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    SolutionDPIncr s = new SolutionDPIncr();
    int output = s.maxProfit(new int[] {2, 1, 4});
    boolean passed = output ==  3;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    SolutionDPIncr s = new SolutionDPIncr();
    int output = s.maxProfit(new int[] {1, 2});
    boolean passed = output ==  1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    SolutionDPIncr s = new SolutionDPIncr();
    int output = s.maxProfit(new int[] {2,4,1,7});
    boolean passed = output ==  6;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    SolutionDPIncr s = new SolutionDPIncr();
    int output = s.maxProfit(new int[] {6,1,3,2,4,7});
    boolean passed = output == 6;
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
