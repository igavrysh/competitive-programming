package com.company;

public class Main {

  public static void test1() {
    Solution solution = new Solution();
    boolean passed = solution.isHappy(19) == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution solution = new Solution();
    boolean passed = solution.isHappy(1) == true;
    System.out.println("test2:" + (passed ? "passed" : "failed"));

  }

  public static void main(String[] args) {
    //test1();
    test2();
  }
}
