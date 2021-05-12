package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {
    int[] input = {1,2,3};
    Solution s = new Solution();
    int[] output = s.plusOne(input);
    boolean passed = Arrays.equals(output, new int[] {1,2,4});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {4,3,2,1};
    Solution s = new Solution();
    int[] output = s.plusOne(input);
    boolean passed = Arrays.equals(output, new int[] {4,3,2,2});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] input = {0};
    Solution s = new Solution();
    int[] output = s.plusOne(input);
    boolean passed = Arrays.equals(output, new int[] {1});
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
