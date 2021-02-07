package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.numberOfMatches(7);
    boolean passed = output == 6;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.numberOfMatches(14);
    boolean passed = output == 13;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }


  public static void main(String[] args) {
    test1();
    test2();
  }
}
