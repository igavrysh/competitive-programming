package com.company;

public class Main {

  public static void test1() {
    int[] tokens = {100};
    int P = 50;
    Solution s = new Solution();
    int output = s.bagOfTokensScore(tokens, P);
    boolean passed = output == 0;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] tokens = {100,200};
    int P = 150;
    Solution s = new Solution();
    int output = s.bagOfTokensScore(tokens, P);
    boolean passed = output == 1;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] tokens = {100, 200, 300, 400};
    int P = 200;
    Solution s = new Solution();
    int output = s.bagOfTokensScore(tokens, P);
    boolean passed = output == 2;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
