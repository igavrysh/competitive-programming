package com.company;

public class Main {

  private static void test1() {
    String[] input = {"flower", "flow", "flight"};
    Solution s = new Solution();
    String output = s.longestCommonPrefix(input);
    boolean passed = output.equals("fl");
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    String[] input = {"flower"};
    Solution s = new Solution();
    String output = s.longestCommonPrefix(input);
    boolean passed = output.equals("flower");
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    String[] input = {"dog","racecar","car"};
    Solution s = new Solution();
    String output = s.longestCommonPrefix(input);
    boolean passed = output.equals("");
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    String[] input = {};
    Solution s = new Solution();
    String output = s.longestCommonPrefix(input);
    boolean passed = output.equals("");
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  private static void test5() {
    String[] input = {""};
    Solution s = new Solution();
    String output = s.longestCommonPrefix(input);
    boolean passed = output.equals("");
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
