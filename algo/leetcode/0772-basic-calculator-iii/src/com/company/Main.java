package com.company;

public class Main {

  public static void test1() {
    String input = "1+1";
    Solution s = new Solution();
    int result = s.calculate(input);
    boolean passed = result == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String input = "6-4/2";
    Solution s = new Solution();
    int result = s.calculate(input);
    boolean passed = result == 4;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String input = "2*(5+5*2)/3+(6/2+8)";
    Solution s = new Solution();
    int result = s.calculate(input);
    boolean passed = result == 21;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    String input = "99+138";
    Solution s = new Solution();
    int result = s.calculate(input);
    boolean passed = result == 237;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
