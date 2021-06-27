package com.company;

public class Main {

  public static void test1() {
    String input = "ababccc";
    Solution s = new Solution();
    int output = s.maxUniqueSplit(input);
    boolean passed = output == 5;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String input = "aba";
    Solution s = new Solution();
    int output = s.maxUniqueSplit(input);
    boolean passed = output == 2;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String input = "aa";
    Solution s = new Solution();
    int output = s.maxUniqueSplit(input);
    boolean passed = output == 1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    String input = "a";
    Solution s = new Solution();
    int output = s.maxUniqueSplit(input);
    boolean passed = output == 1;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }

}
