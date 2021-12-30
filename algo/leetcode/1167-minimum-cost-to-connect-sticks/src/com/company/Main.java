package com.company;

public class Main {

  public static void test1() {
    int[] sticks = {2,4,3};
    Solution s = new Solution();
    int output = s.connectSticks(sticks);
    boolean passed = output == 14;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] sticks = {1,8,3,5};
    Solution s = new Solution();
    int output = s.connectSticks(sticks);
    boolean passed = output == 30;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] sticks = {5};
    Solution s = new Solution();
    int output = s.connectSticks(sticks);
    boolean passed = output == 0;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
