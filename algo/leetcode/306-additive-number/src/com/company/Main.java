package com.company;

public class Main {

  public static void test1() {
    String input = "112358";
    Solution s = new Solution();
    boolean output = s.isAdditiveNumber(input);
    boolean passed = output == true;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String input = "1122";
    Solution s = new Solution();
    boolean output = s.isAdditiveNumber(input);
    boolean passed = output == false;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String input = "199100199";
    Solution s = new Solution();
    boolean output = s.isAdditiveNumber(input);
    boolean passed = output == true;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    String input = "199001200";
    Solution s = new Solution();
    boolean output = s.isAdditiveNumber(input);
    boolean passed = output == false;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    String input = "101";
    Solution s = new Solution();
    boolean output = s.isAdditiveNumber(input);
    boolean passed = output == true;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    //test1();
    //test2();
    test3();
    test4();
    test5();
  }
}
