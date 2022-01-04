package com.company;

public class Main {

  public static void test1() {
    String[] words = new String[] { "hello","leetcode" };
    String order = "hlabcdefgijkmnopqrstuvwxyz";
    Solution solution = new Solution();
    boolean output = solution.isAlienSorted(words, order);
    boolean passed = output == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String[] words = new String[] { "word","world","row" };
    String order = "worldabcefghijkmnpqstuvxyz";
    Solution solution = new Solution();
    boolean output = solution.isAlienSorted(words, order);
    boolean passed = output == false;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String[] words = new String[] { "apple","app" };
    String order = "abcdefghijklmnopqrstuvwxyz";
    Solution solution = new Solution();
    boolean output = solution.isAlienSorted(words, order);
    boolean passed = output == false;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
