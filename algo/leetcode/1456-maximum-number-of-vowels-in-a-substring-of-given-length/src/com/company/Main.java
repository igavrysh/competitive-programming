package com.company;

public class Main {

  public static void test1() {
    String input = "abciiidef";
    int k = 3;
    Solution s = new Solution();
    int output = s.maxVowels(input, k);
    boolean passed = output == 3;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String input = "aeiou";
    int k = 2;
    Solution s = new Solution();
    int output = s.maxVowels(input, k);
    boolean passed = output == 2;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String input = "leetcode";
    int k = 3;
    Solution s = new Solution();
    int output = s.maxVowels(input, k);
    boolean passed = output == 2;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    String input = "rhythms";
    int k = 4;
    Solution s = new Solution();
    int output = s.maxVowels(input, k);
    boolean passed = output == 0;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    String input = "tryhard";
    int k = 4;
    Solution s = new Solution();
    int output = s.maxVowels(input, k);
    boolean passed = output == 1;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }
}
