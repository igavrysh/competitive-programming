package com.company;

public class Main {

  public static void test1() {
    String input = "00110";
    Solution s = new Solution();
    int output = s.minFlipsMonoIncr(input);
    boolean passed = output == 1;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String input = "010110";
    Solution s = new Solution();
    int output = s.minFlipsMonoIncr(input);
    boolean passed = output == 2;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String input = "00011000";
    Solution s = new Solution();
    int output = s.minFlipsMonoIncr(input);
    boolean passed = output == 2;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
