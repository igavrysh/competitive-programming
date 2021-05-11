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

  public static void test11() {
    Solution2 s = new Solution2();
    String output = s.getPermutation(3, 3);
    boolean passed = output.equals("213");
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    Solution2 s = new Solution2();
    String output = s.getPermutation(4, 9);
    boolean passed = output.equals("2314");
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    Solution2 s = new Solution2();
    String output = s.getPermutation(3, 1);
    boolean passed = output.equals("123");
    System.out.println("test13: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test11();
    test12();
    test13();
  }
}
