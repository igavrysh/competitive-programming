package com.company;

public class Main {

  public static void test1() {
    int[] input = {1,2,0};
    Solution s = new Solution();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 3;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {3,4,-1,1};
    Solution s = new Solution();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 2;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] input = {7,8,9,11,12};
    Solution s = new Solution();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] input = {1};
    Solution s = new Solution();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 2;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[] input = {0,2,2,1,1};
    Solution s = new Solution();
    int output = s.firstMissingPositive(input);
    boolean passed = output == 3;
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
