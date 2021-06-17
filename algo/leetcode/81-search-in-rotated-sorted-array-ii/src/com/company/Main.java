package com.company;

public class Main {

  public static void test1() {
    int[] input = {2,5,6,0,0,1,2};
    int target = 0;
    Solution s = new Solution();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {2,5,6,0,0,1,2};
    int target = 3;
    Solution s = new Solution();
    boolean output = s.search(input, target);
    boolean passed = output == false;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] input = {2,5,6,0,0,1,2};
    int target = 2;
    Solution s = new Solution();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] input = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
    int target = 2;
    Solution s = new Solution();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[] input = {0,0,1,1,2,0};
    int target = 2;
    Solution s = new Solution();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    int[] input = {1,0,1,1,1};
    int target = 0;
    Solution s = new Solution();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    int[] input = {1};
    int target = 1;
    Solution s = new Solution();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test7: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    int[] input = {2,5,6,0,0,1,2};
    int target = 0;
    SolutionOptimized s = new SolutionOptimized();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    int[] input = {2,5,6,0,0,1,2};
    int target = 3;
    SolutionOptimized s = new SolutionOptimized();
    boolean output = s.search(input, target);
    boolean passed = output == false;
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    int[] input = {2,5,6,0,0,1,2};
    int target = 2;
    SolutionOptimized s = new SolutionOptimized();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test13: " + (passed ? "passed" : "failed"));
  }

  public static void test14() {
    int[] input = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
    int target = 2;
    SolutionOptimized s = new SolutionOptimized();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test14: " + (passed ? "passed" : "failed"));
  }

  public static void test15() {
    int[] input = {0,0,1,1,2,0};
    int target = 2;
    SolutionOptimized s = new SolutionOptimized();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test15: " + (passed ? "passed" : "failed"));
  }

  public static void test16() {
    int[] input = {1,0,1,1,1};
    int target = 0;
    SolutionOptimized s = new SolutionOptimized();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test16: " + (passed ? "passed" : "failed"));
  }

  public static void test17() {
    int[] input = {1};
    int target = 1;
    SolutionOptimized s = new SolutionOptimized();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test17: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
    test11();
    test12();
    test13();
    test14();
    test15();
    test16();
  }
}
