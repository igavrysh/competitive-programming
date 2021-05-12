package com.company;

public class Main {

  public static void test1() {
    String a = "11";
    String b = "1";
    Solution s = new Solution();
    String output = s.addBinary(a, b);
    boolean passed = output.equals("100");
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String a = "1010";
    String b = "1011";
    Solution s = new Solution();
    String output = s.addBinary(a, b);
    boolean passed = output.equals("10101");
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
