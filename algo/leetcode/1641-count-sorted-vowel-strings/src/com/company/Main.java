package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.countVowelStrings(1);
    boolean passed = output == 5;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.countVowelStrings(2);
    boolean passed = output == 15;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    int output = s.countVowelStrings(33);
    boolean passed = output == 66045;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    SolutionMemoryOptimized s = new SolutionMemoryOptimized();
    int output = s.countVowelStrings(1);
    boolean passed = output == 5;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    SolutionMemoryOptimized s = new SolutionMemoryOptimized();
    int output = s.countVowelStrings(2);
    boolean passed = output == 15;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    SolutionMemoryOptimized s = new SolutionMemoryOptimized();
    int output = s.countVowelStrings(33);
    boolean passed = output == 66045;
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
  }
}
