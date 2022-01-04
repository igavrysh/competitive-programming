package com.company;

public class Main {

  private static void test1() {
    Solution s = new Solution();
    String output = s.intToRoman(3);
    boolean passed = output.equals("III");
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    Solution s = new Solution();
    String output = s.intToRoman(4);
    boolean passed = output.equals("IV");
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    Solution s = new Solution();
    String output = s.intToRoman(9);
    boolean passed = output.equals("IX");
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    Solution s = new Solution();
    String output = s.intToRoman(58);
    boolean passed = output.equals("LVIII");
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  private static void test5() {
    Solution s = new Solution();
    String output = s.intToRoman(1994);
    boolean passed = output.equals("MCMXCIV");
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
