package com.company;

public class Main {

  public static void test1() {
    Solution solution = new Solution();
    boolean output = solution.isMatch("abc", "abc");
    boolean passed = output == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution solution = new Solution();
    boolean output = solution.isMatch("abc", ".*");
    boolean passed = output == true;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution solution = new Solution();
    boolean output = solution.isMatch("abc", "*");
    boolean passed = output == false;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution solution = new Solution();
    boolean output = solution.isMatch("abcd", "ab.d");
    boolean passed = output == true;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    Solution solution = new Solution();
    boolean output = solution.isMatch("aa", "a");
    boolean passed = output == false;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    Solution solution = new Solution();
    boolean output = solution.isMatch("aa", "a*");
    boolean passed = output == true;
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    Solution solution = new Solution();
    boolean output = solution.isMatch("ab", ".*");
    boolean passed = output == true;
    System.out.println("test7:" + (passed ? "passed" : "failed"));
  }

  public static void test8() {
    Solution solution = new Solution();
    boolean output = solution.isMatch("aab", "c*a*b");
    boolean passed = output == true;
    System.out.println("test8:" + (passed ? "passed" : "failed"));
  }

  public static void test9() {
    Solution solution = new Solution();
    boolean output = solution.isMatch("mississippi", "mis*is*p*.");
    boolean passed = output == false;
    System.out.println("test9:" + (passed ? "passed" : "failed"));
  }

  public static void test10() {
    Solution solution = new Solution();
    boolean output = solution.isMatch("mississippi", "mis*is*ip*.");
    boolean passed = output == true;
    System.out.println("test10:" + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    Solution solution = new Solution();
    boolean output = solution.isMatch("aaa", "ab*a*c*a");
    boolean passed = output == true;
    System.out.println("test11:" + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    Solution solution = new Solution();
    boolean output = solution.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b");
    boolean passed = output == true;
    System.out.println("test12:" + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    Solution solution = new Solution();
    boolean output = solution.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*c");
    boolean passed = output == false;
    System.out.println("test13:" + (passed ? "passed" : "failed"));
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
  }
}
