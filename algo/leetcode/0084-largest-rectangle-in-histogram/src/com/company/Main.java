package com.company;

public class Main {

  public static void test1() {
    int[] heights = {2,1,5,6,2,3};
    SolutionStack s = new SolutionStack();
    int output = s.largestRectangleArea(heights);
    boolean passed = output == 10;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] heights = {2,4};
    SolutionStack s = new SolutionStack();
    int output = s.largestRectangleArea(heights);
    boolean passed = output == 4;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] heights = {2,1,2};
    SolutionStack s = new SolutionStack();
    int output = s.largestRectangleArea(heights);
    boolean passed = output == 3;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void testStackImproved1() {
    int[] heights = {2,1,5,6,2,3};
    SolutionStackImproved s = new SolutionStackImproved();
    int output = s.largestRectangleArea(heights);
    boolean passed = output == 10;
    System.out.println("testStackImproved1: " + (passed ? "passed" : "failed"));
  }

  public static void testStackImproved2() {
    int[] heights = {2,4};
    SolutionStackImproved s = new SolutionStackImproved();
    int output = s.largestRectangleArea(heights);
    boolean passed = output == 4;
    System.out.println("testStackImproved2: " + (passed ? "passed" : "failed"));
  }

  public static void testStackImproved3() {
    int[] heights = {2,1,2};
    SolutionStackImproved s = new SolutionStackImproved();
    int output = s.largestRectangleArea(heights);
    boolean passed = output == 3;
    System.out.println("testStackImproved2: " + (passed ? "passed" : "failed"));
  }


  public static void main(String[] args) {
    test1();
    test2();
    test3();
    testStackImproved1();
    testStackImproved2();
    testStackImproved3();
  }
}
