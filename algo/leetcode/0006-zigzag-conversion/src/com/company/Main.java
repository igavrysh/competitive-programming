package com.company;

public class Main {

  private static void test1() {
    String input = "PAYPALISHIRING";
    Solution s = new Solution();
    String output = s.convert(input, 3);
    boolean passed = output.equals("PAHNAPLSIIGYIR");
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    String input = "PAYPALISHIRING";
    Solution s = new Solution();
    String output = s.convert(input, 4);
    boolean passed = output.equals("PINALSIGYAHRPI");
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    String input = "A";
    Solution s = new Solution();
    String output = s.convert(input, 1);
    boolean passed = output.equals("A");
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    String input = "ABCD";
    Solution s = new Solution();
    String output = s.convert(input, 2);
    boolean passed = output.equals("ACBD");
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  private static void test5() {
    String input = "AB";
    Solution s = new Solution();
    String output = s.convert(input, 1);
    boolean passed = output.equals("AB");
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  private static void test6() {
    String input = "PAYPALISHIRING";
    SolutionStringBuffer s = new SolutionStringBuffer();
    String output = s.convert(input, 3);
    boolean passed = output.equals("PAHNAPLSIIGYIR");
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }

  private static void test7() {
    String input = "PAYPALISHIRING";
    SolutionStringBuffer s = new SolutionStringBuffer();
    String output = s.convert(input, 4);
    boolean passed = output.equals("PINALSIGYAHRPI");
    System.out.println("test7:" + (passed ? "passed" : "failed"));
  }

  private static void test8() {
    String input = "A";
    SolutionStringBuffer s = new SolutionStringBuffer();
    String output = s.convert(input, 1);
    boolean passed = output.equals("A");
    System.out.println("test8:" + (passed ? "passed" : "failed"));
  }

  private static void test9() {
    String input = "ABCD";
    SolutionStringBuffer s = new SolutionStringBuffer();
    String output = s.convert(input, 2);
    boolean passed = output.equals("ACBD");
    System.out.println("test9:" + (passed ? "passed" : "failed"));
  }

  private static void test10() {
    String input = "AB";
    SolutionStringBuffer s = new SolutionStringBuffer();
    String output = s.convert(input, 1);
    boolean passed = output.equals("AB");
    System.out.println("test10:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
    test8();
    test9();
    test10();
  }
}
