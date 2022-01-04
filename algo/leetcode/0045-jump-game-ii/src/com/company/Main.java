package com.company;

public class Main {

  public static void test1() {
    int[] input = {2,3,1,1,4};
    Solution s = new Solution();
    int output = s.jump(input);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {2,3,0,1,4};
    Solution s = new Solution();
    int output = s.jump(input);
    boolean passed = output == 2;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] input = {5,1,1,1,1,1};
    Solution s = new Solution();
    int output = s.jump(input);
    boolean passed = output == 1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
