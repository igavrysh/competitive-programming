package com.company;

public class Main {

  public static String getMethodName() {
    return new Throwable()
        .getStackTrace()[1]
        .getMethodName();
  }

  public static void test1() {
    int[][] input = {{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 7;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] input = {{1,2},{2,3},{3,4},{1,2}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 4;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] input = {{1,2},{2,3},{3,4}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 3;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[][] input = {{1,2},{1,2},{3,3},{1,5},{1,5}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 5;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[][] input = {{1,5},{1,5},{1,5},{2,3},{2,3}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 5;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testImproved1() {
    int[][] input = {{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}};
    SolutionImproved s = new SolutionImproved();
    int output = s.maxEvents(input);
    boolean passed = output == 7;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testImproved2() {
    int[][] input = {{1,2},{2,3},{3,4},{1,2}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 4;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testImproved3() {
    int[][] input = {{1,2},{2,3},{3,4}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 3;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testImproved4() {
    int[][] input = {{1,2},{1,2},{3,3},{1,5},{1,5}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 5;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testImproved5() {
    int[][] input = {{1,5},{1,5},{1,5},{2,3},{2,3}};
    Solution s = new Solution();
    int output = s.maxEvents(input);
    boolean passed = output == 5;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    testImproved1();
    testImproved2();
    testImproved3();
    testImproved4();
    testImproved5();
  }
}
