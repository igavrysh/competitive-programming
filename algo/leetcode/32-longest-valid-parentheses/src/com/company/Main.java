package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.longestValidParentheses("(()");
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.longestValidParentheses(")()())");
    boolean passed = output == 4;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    int output = s.longestValidParentheses("");
    boolean passed = output == 0;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    int output = s.longestValidParentheses("()(())");
    boolean passed = output == 6;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    Solution s = new Solution();
    int output = s.longestValidParentheses(")()())()()(");
    boolean passed = output == 4;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    Solution s = new Solution();
    int output = s.longestValidParentheses("()");
    boolean passed = output == 2;
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    Solution s = new Solution();
    int output = s.longestValidParentheses("(()(()))");
    boolean passed = output == 6;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    //test1();
    //test2();
    //test3();
    test4();
    test5();
    test6();
  }
}
