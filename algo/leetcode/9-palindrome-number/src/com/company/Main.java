package com.company;

public class Main {

  private static void test1() {
    int input = 121;
    Solution s = new Solution();
    boolean output = s.isPalindrome(input);
    boolean passed = output == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    int input = -121;
    Solution s = new Solution();
    boolean output = s.isPalindrome(input);
    boolean passed = output == false;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    int input = 10;
    Solution s = new Solution();
    boolean output = s.isPalindrome(input);
    boolean passed = output == false;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
