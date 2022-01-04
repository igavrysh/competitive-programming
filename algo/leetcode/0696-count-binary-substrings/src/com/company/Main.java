package com.company;

public class Main {

  public static void test1() {
    String input = "00110011";
    Solution s = new Solution();
    int output = s.countBinarySubstrings(input);
    boolean passed = output == 6;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String input = "10101";
    Solution s = new Solution();
    int output = s.countBinarySubstrings(input);
    boolean passed = output == 4;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String input = "001100011";
    Solution s = new Solution();
    int output = s.countBinarySubstrings(input);
    boolean passed = output == 6;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
