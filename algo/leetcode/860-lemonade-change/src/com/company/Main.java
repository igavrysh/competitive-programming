package com.company;

public class Main {

  public static void test1() {
    int[] input = new int[] { 5,5,5,10,20 };
    Solution solution = new Solution();
    boolean passed = solution.lemonadeChange(input) == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = new int[] { 5,5,10 };
    Solution solution = new Solution();
    boolean passed = solution.lemonadeChange(input) == true;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] input = new int[] { 10,10  };
    Solution solution = new Solution();
    boolean passed = solution.lemonadeChange(input) == false;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] input = new int[] { 5,5,10,10,20 };
    Solution solution = new Solution();
    boolean passed = solution.lemonadeChange(input) == false;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[] input = new int[] { 5,5,5,5,10,5,10,10,10,20 };
    Solution solution = new Solution();
    boolean passed = solution.lemonadeChange(input) == true;
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
