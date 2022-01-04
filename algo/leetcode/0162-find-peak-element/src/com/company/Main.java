package com.company;

public class Main {

  public static void test1() {
    int[] input = {1,2,3,1};
    SolutionBSOptimized s = new SolutionBSOptimized();
    int output = s.findPeakElement(input);
    boolean passed = output == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {1,2,1,3,5,6,4};
    SolutionBSOptimized s = new SolutionBSOptimized();
    int output = s.findPeakElement(input);
    boolean passed = output == 1 || output == 5;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] input = {};
    SolutionBSOptimized s = new SolutionBSOptimized();
    int output = s.findPeakElement(input);
    boolean passed = output == -1;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] input = {1};
    SolutionBSOptimized s = new SolutionBSOptimized();
    int output = s.findPeakElement(input);
    boolean passed = output == 0;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[] input = {1, 2};
    SolutionBSOptimized s = new SolutionBSOptimized();
    int output = s.findPeakElement(input);
    boolean passed = output == 1;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    int[] input = {2, 1};
    SolutionBSOptimized s = new SolutionBSOptimized();
    int output = s.findPeakElement(input);
    boolean passed = output == 0;
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    int[] input = {1, 1};
    SolutionBSOptimized s = new SolutionBSOptimized();
    int output = s.findPeakElement(input);
    boolean passed = output == 0 || output == 1;
    System.out.println("test7:" + (passed ? "passed" : "failed"));
  }

  public static void test8() {
    int[] input = {1, 1, 1};
    SolutionBSOptimized s = new SolutionBSOptimized();
    int output = s.findPeakElement(input);
    boolean passed = output == 0 || output == 1 || output == 2;
    System.out.println("test8:" + (passed ? "passed" : "failed"));
  }

  public static void test9() {
    int[] input = {-2147483648,-2147483647};
    SolutionBSOptimized s = new SolutionBSOptimized();
    int output = s.findPeakElement(input);
    boolean passed = output == 1;
    System.out.println("test9:" + (passed ? "passed" : "failed"));
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
  }
}
