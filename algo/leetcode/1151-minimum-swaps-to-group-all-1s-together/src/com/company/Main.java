package com.company;

public class Main {

  public static void test1() {
    int[] data = {1,0,1,0,1};
    Solution s = new Solution();
    int output = s.minSwaps(data);
    boolean passed = output == 1;
    System.out.println("test1: " + (passed ? "passed" : "failed" ));
  }

  public static void test2() {
    int[] data = {0,0,0,1,0};
    Solution s = new Solution();
    int output = s.minSwaps(data);
    boolean passed = output == 0;
    System.out.println("test2: " + (passed ? "passed" : "failed" ));
  }

  public static void test3() {
    int[] data = {1,0,1,0,1,0,0,1,1,0,1};
    Solution s = new Solution();
    int output = s.minSwaps(data);
    boolean passed = output == 3;
    System.out.println("test3: " + (passed ? "passed" : "failed" ));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
