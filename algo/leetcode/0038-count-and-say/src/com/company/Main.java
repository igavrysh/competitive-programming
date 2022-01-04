package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    String output = s.countAndSay(1);
    boolean passed = output.equals("1");
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    String output = s.countAndSay(2);
    boolean passed = output.equals("11");
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    String output = s.countAndSay(3);
    boolean passed = output.equals("21");
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    String output = s.countAndSay(4);
    boolean passed = output.equals("1211");
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    Solution s = new Solution();
    String output = s.countAndSay(5);
    boolean passed = output.equals("111221");
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    Solution s = new Solution();
    String output = s.countAndSay(6);
    boolean passed = output.equals("312211");
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    SolutionWithStringBuilder s = new SolutionWithStringBuilder();
    String output = s.countAndSay(1);
    boolean passed = output.equals("1");
    System.out.println("test7: " + (passed ? "passed" : "failed"));
  }

  public static void test8() {
    SolutionWithStringBuilder s = new SolutionWithStringBuilder();
    String output = s.countAndSay(2);
    boolean passed = output.equals("11");
    System.out.println("test8: " + (passed ? "passed" : "failed"));
  }

  public static void test9() {
    SolutionWithStringBuilder s = new SolutionWithStringBuilder();
    String output = s.countAndSay(3);
    boolean passed = output.equals("21");
    System.out.println("test9: " + (passed ? "passed" : "failed"));
  }

  public static void test10() {
    SolutionWithStringBuilder s = new SolutionWithStringBuilder();
    String output = s.countAndSay(4);
    boolean passed = output.equals("1211");
    System.out.println("test10: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    SolutionWithStringBuilder s = new SolutionWithStringBuilder();
    String output = s.countAndSay(5);
    boolean passed = output.equals("111221");
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    SolutionWithStringBuilder s = new SolutionWithStringBuilder();
    String output = s.countAndSay(6);
    boolean passed = output.equals("312211");
    System.out.println("test12: " + (passed ? "passed" : "failed"));
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
    test11();
    test12();
  }
}
