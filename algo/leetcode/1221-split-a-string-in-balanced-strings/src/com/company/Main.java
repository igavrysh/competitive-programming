package com.company;

public class Main {

  private static void test1() {
    String input = "RLRRLLRLRL";
    Solution solution = new Solution();
    int output = solution.balancedStringSplit(input);
    boolean passed = output == 4;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    String input = "RLLLLRRRLR";
    Solution solution = new Solution();
    int output = solution.balancedStringSplit(input);
    boolean passed = output == 3;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    String input = "LLLLRRRR";
    Solution solution = new Solution();
    int output = solution.balancedStringSplit(input);
    boolean passed = output == 1;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    String input = "RLRRRLLRLL";
    Solution solution = new Solution();
    int output = solution.balancedStringSplit(input);
    boolean passed = output == 2;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
