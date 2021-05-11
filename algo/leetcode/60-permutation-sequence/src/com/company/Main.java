package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    String output = s.getPermutation(3, 3);
    boolean passed = output.equals("213");
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    String output = s.getPermutation(4, 9);
    boolean passed = output.equals("2314");
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    String output = s.getPermutation(3, 1);
    boolean passed = output.equals("123");
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
