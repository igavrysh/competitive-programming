package com.company;

public class Main {

  public static void test1() {
    int[] input = {1,2,0};
    Solution s = new Solution();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 3;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {3,4,-1,1};
    Solution s = new Solution();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 2;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] input = {7,8,9,11,12};
    Solution s = new Solution();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] input = {1};
    Solution s = new Solution();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 2;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[] input = {0,2,2,1,1};
    Solution s = new Solution();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 3;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    int[] input = {1,2,0};
    SolutionFreqArray s = new SolutionFreqArray();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 3;
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    int[] input = {3,4,-1,1};
    SolutionFreqArray s = new SolutionFreqArray();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 2;
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    int[] input = {7,8,9,11,12};
    SolutionFreqArray s = new SolutionFreqArray();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 1;
    System.out.println("test13: " + (passed ? "passed" : "failed"));
  }

  public static void test14() {
    int[] input = {1};
    SolutionFreqArray s = new SolutionFreqArray();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 2;
    System.out.println("test14: " + (passed ? "passed" : "failed"));
  }

  public static void test15() {
    int[] input = {0,2,2,1,1};
    SolutionFreqArray s = new SolutionFreqArray();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 3;
    System.out.println("test15: " + (passed ? "passed" : "failed"));
  }

  public static void test21() {
    int[] input = {1,2,0};
    SolutionConstantSpace s = new SolutionConstantSpace();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 3;
    System.out.println("test21: " + (passed ? "passed" : "failed"));
  }

  public static void test22() {
    int[] input = {3,4,-1,1};
    SolutionConstantSpace s = new SolutionConstantSpace();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 2;
    System.out.println("test22: " + (passed ? "passed" : "failed"));
  }

  public static void test23() {
    int[] input = {7,8,9,11,12};
    SolutionConstantSpace s = new SolutionConstantSpace();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 1;
    System.out.println("test23: " + (passed ? "passed" : "failed"));
  }

  public static void test24() {
    int[] input = {1};
    SolutionConstantSpace s = new SolutionConstantSpace();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 2;
    System.out.println("test24: " + (passed ? "passed" : "failed"));
  }

  public static void test25() {
    int[] input = {0,2,2,1,1};
    SolutionConstantSpace s = new SolutionConstantSpace();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 3;
    System.out.println("test25: " + (passed ? "passed" : "failed"));
  }

  public static void test26() {
    int[] input = {1,1};
    SolutionConstantSpace s = new SolutionConstantSpace();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 2;
    System.out.println("test26: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test11();
    test12();
    test13();
    test14();
    test15();
    test21();
    test22();
    test23();
    test24();
    test25();
    test26();

  }
}
