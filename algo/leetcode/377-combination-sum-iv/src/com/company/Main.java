package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int result = s.combinationSum4(new int[] {1,2,3}, 4);
    boolean passed = result == 7;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int result = s.combinationSum4(new int[] {3}, 9);
    boolean passed = result == 1;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    int result = s.combinationSum4(new int[] {11}, 13);
    boolean passed = result == 0;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    int result = s.combinationSum4(new int[] {2, 1, 3}, 35);
    boolean passed = result == 1132436852;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    SolutionArray s = new SolutionArray();
    int result = s.combinationSum4(new int[] {1,2,3}, 4);
    boolean passed = result == 7;
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    SolutionArray s = new SolutionArray();
    int result = s.combinationSum4(new int[] {3}, 9);
    boolean passed = result == 1;
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    SolutionArray s = new SolutionArray();
    int result = s.combinationSum4(new int[] {11}, 13);
    boolean passed = result == 0;
    System.out.println("test13: " + (passed ? "passed" : "failed"));
  }

  public static void test14() {
    SolutionArray s = new SolutionArray();
    int result = s.combinationSum4(new int[] {2, 1, 3}, 35);
    boolean passed = result == 1132436852;
    System.out.println("test14: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();

    test11();
    test12();
    test13();
    test14();
  }
}
