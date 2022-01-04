package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.numJewelsInStones("aA", "aAAbbbb");
    boolean passed = output == 3;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.numJewelsInStones("", "aAAbbbb");
    boolean passed = output == 0;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    int output = s.numJewelsInStones("ab", "");
    boolean passed = output == 0;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
