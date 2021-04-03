package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int[] input = { 2, 3, 5 };
    int[] output = s.getSumAbsoluteDifferences(input);
    boolean passed = output[0] == 4
        && output[1] == 3
        && output[2] == 5;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
