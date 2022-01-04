package com.company;

public class Main {
  public static void test1() {
    String s = "abc";
    String t = "ahbgdc";
    Solution solution = new Solution();
    boolean output = solution.isSubsequence(s, t);
    boolean passed = output == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String s = "axc";
    String t = "ahbgdc";
    Solution solution = new Solution();
    boolean output = solution.isSubsequence(s, t);
    boolean passed = output == false;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String s = "";
    String t = "ahbgdc";
    Solution solution = new Solution();
    boolean output = solution.isSubsequence(s, t);
    boolean passed = output == true;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    String s = "ahbgdc";
    String t = "";
    Solution solution = new Solution();
    boolean output = solution.isSubsequence(s, t);
    boolean passed = output == false;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    String s = "";
    String t = "";
    Solution solution = new Solution();
    boolean output = solution.isSubsequence(s, t);
    boolean passed = output == true;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }
}
