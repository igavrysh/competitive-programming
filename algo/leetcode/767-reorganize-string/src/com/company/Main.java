package com.company;

public class Main {

  public static void test1() {
    Solution solution = new Solution();
    String output = solution.reorganizeString("aab");
    boolean passed = output.equals("aba");
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution solution = new Solution();
    String output = solution.reorganizeString("aaab");
    boolean passed = output.equals("");
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution solution = new Solution();
    String output = solution.reorganizeString("vvvlo");
    boolean passed = output.equals("vlvov");
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
