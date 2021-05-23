package com.company;

public class Main {
  public static void test1() {
    String word1 = "horse";
    String word2 = "ros";
    Solution s = new Solution();
    int output = s.minDistance(word1, word2);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String word1 = "intention";
    String word2 = "execution";
    Solution s = new Solution();
    int output = s.minDistance(word1, word2);
    boolean passed = output == 5;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
