package com.company;

public class Main {

  public static void test1() {
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.trap(new int[]{0});
    boolean passed = output == 0;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.trap(new int[]{0,0,0});
    boolean passed = output == 0;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.trap(new int[]{0,1,2,3});
    boolean passed = output == 0;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.trap(new int[]{0,0,10,0,0});
    boolean passed = output == 0;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.trap(new int[] {1,0,1});
    boolean passed = output == 1;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.trap(new int[] {0,1,1,0});
    boolean passed = output == 0;
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.trap(new int[] {0,1,0,1,0,1});
    boolean passed = output == 2;
    System.out.println("test7:" + (passed ? "passed" : "failed"));
  }

  public static void test8() {
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
    boolean passed = output == 6;
    System.out.println("test8:" + (passed ? "passed" : "failed"));
  }

  public static void test9() {
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.trap(new int[] {4,2,0,3,2,5});
    boolean passed = output == 9;
    System.out.println("test9:" + (passed ? "passed" : "failed"));
  }

  public static void test10() {
    SolutionTwoPointers s = new SolutionTwoPointers();
    int output = s.trap(new int[] {0,7,1,4,6});
    boolean passed = output == 7;
    System.out.println("test10:" + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    SolutionDP s = new SolutionDP();
    int output = s.trap(new int[]{0});
    boolean passed = output == 0;
    System.out.println("test11:" + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    SolutionDP s = new SolutionDP();
    int output = s.trap(new int[]{0,0,0});
    boolean passed = output == 0;
    System.out.println("test12:" + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    SolutionDP s = new SolutionDP();
    int output = s.trap(new int[]{0,1,2,3});
    boolean passed = output == 0;
    System.out.println("test13:" + (passed ? "passed" : "failed"));
  }

  public static void test14() {
    SolutionDP s = new SolutionDP();
    int output = s.trap(new int[]{0,0,10,0,0});
    boolean passed = output == 0;
    System.out.println("test14:" + (passed ? "passed" : "failed"));
  }

  public static void test15() {
    SolutionDP s = new SolutionDP();
    int output = s.trap(new int[] {1,0,1});
    boolean passed = output == 1;
    System.out.println("test15:" + (passed ? "passed" : "failed"));
  }

  public static void test16() {
    SolutionDP s = new SolutionDP();
    int output = s.trap(new int[] {0,1,1,0});
    boolean passed = output == 0;
    System.out.println("test16:" + (passed ? "passed" : "failed"));
  }

  public static void test17() {
    SolutionDP s = new SolutionDP();
    int output = s.trap(new int[] {0,1,0,1,0,1});
    boolean passed = output == 2;
    System.out.println("test17:" + (passed ? "passed" : "failed"));
  }

  public static void test18() {
    SolutionDP s = new SolutionDP();
    int output = s.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
    boolean passed = output == 6;
    System.out.println("test18:" + (passed ? "passed" : "failed"));
  }

  public static void test19() {
    SolutionDP s = new SolutionDP();
    int output = s.trap(new int[] {4,2,0,3,2,5});
    boolean passed = output == 9;
    System.out.println("test19:" + (passed ? "passed" : "failed"));
  }

  public static void test20() {
    SolutionDP s = new SolutionDP();
    int output = s.trap(new int[] {0,7,1,4,6});
    boolean passed = output == 7;
    System.out.println("test20:" + (passed ? "passed" : "failed"));
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
    test12();
    test13();
    test14();
    test15();
    test16();
    test17();
    test18();
    test19();
    test20();
  }
}
