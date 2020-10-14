package com.company;

public class Main {

  private static void test1() {
    int[] height = { 1, 1};
    SolutionBruteForce s = new SolutionBruteForce();
    int output = s.maxArea(height);
    boolean passed = output == 1;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    int[] height = { 4, 3, 2, 1, 4 };
    SolutionBruteForce s = new SolutionBruteForce();
    int output = s.maxArea(height);
    boolean passed = output == 16;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    int[] height = { 1, 2, 1 };
    SolutionBruteForce s = new SolutionBruteForce();
    int output = s.maxArea(height);
    boolean passed = output == 2;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    int[] height = { 1, 1};
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.maxArea(height);
    boolean passed = output == 1;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  private static void test5() {
    int[] height = { 4, 3, 2, 1, 4 };
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.maxArea(height);
    boolean passed = output == 16;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  private static void test6() {
    int[] height = { 1, 2, 1 };
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.maxArea(height);
    boolean passed = output == 2;
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }

  private static void test7() {
    int [] height = {1,8,6,2,5,4,8,3,7};
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.maxArea(height);
    boolean passed = output == 49;
    System.out.println("test7:" + (passed ? "passed" : "failed"));
  }

  private static void test8() {
    int [] height = {2,3,4,5,18,17,6};
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.maxArea(height);
    boolean passed = output == 17;
    System.out.println("test8:" + (passed ? "passed" : "failed"));

  }

  private static void test9() {
    int [] height = {1,3,2,5,25,24,5};
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.maxArea(height);
    boolean passed = output == 24;
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
