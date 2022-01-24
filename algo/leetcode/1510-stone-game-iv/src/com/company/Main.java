package com.company;

public class Main {

  public static void test1() {
    int n = 1;
    Solution s = new Solution();
    boolean output = s.winnerSquareGame(n);
    boolean passed = output == true;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int n = 2;
    Solution s = new Solution();
    boolean output = s.winnerSquareGame(n);
    boolean passed = output == false;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int n = 4;
    Solution s = new Solution();
    boolean output = s.winnerSquareGame(n);
    boolean passed = output == true;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
