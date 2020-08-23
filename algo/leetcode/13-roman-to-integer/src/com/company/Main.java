package com.company;

public class Main {

  private static void test1() {
    String input = "III";
    boolean passed = new Solution().romanToInt(input) == 3;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    String input = "IV";
    boolean passed = new Solution().romanToInt(input) == 4;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    String input = "IX";
    boolean passed = new Solution().romanToInt(input) == 9;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    String input = "LVIII";
    boolean passed = new Solution().romanToInt(input) == 58;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  private static void test5() {
    String input = "MCMXCIV";
    boolean passed = new Solution().romanToInt(input) == 1994;
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
