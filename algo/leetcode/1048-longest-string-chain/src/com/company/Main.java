package com.company;

public class Main {

  public static void test1() {
    String[] words = {"a","b","ba","bca","bda","bdca"};
    Solution s = new Solution();
    int output = s.longestStrChain(words);
    boolean passed = output == 4;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
