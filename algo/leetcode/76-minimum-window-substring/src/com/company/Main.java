package com.company;

public class Main {

  public static void test1() {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    Solution sol = new Solution();
    String output = sol.minWindow(s, t);
    boolean passed = output.equals("BANC");
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String s = "a";
    String t = "a";
    Solution sol = new Solution();
    String output = sol.minWindow(s, t);
    boolean passed = output.equals("a");
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
