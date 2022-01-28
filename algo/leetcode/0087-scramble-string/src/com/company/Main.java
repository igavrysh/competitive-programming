package com.company;

public class Main {

  public static void test1() {
    String s1 = "great", s2 = "rgeat";
    Solution s = new Solution();
    boolean output = s.isScramble(s1, s2);
    boolean passed = output == true;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String s1 = "abcde", s2 = "caebd";
    Solution s = new Solution();
    boolean output = s.isScramble(s1, s2);
    boolean passed = output == false;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String s1 = "a", s2 = "a";
    Solution s = new Solution();
    boolean output = s.isScramble(s1, s2);
    boolean passed = output == true;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    String s1 = "abcd", s2 = "dacb";
    Solution s = new Solution();
    boolean output = s.isScramble(s1, s2);
    boolean passed = output == true;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    String s1 = "abcdbdacbdac", s2 = "bdacabcdbdac";
    Solution s = new Solution();
    boolean output = s.isScramble(s1, s2);
    boolean passed = output == true;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }
}