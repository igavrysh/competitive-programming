package com.company;

public class Main {

  public static void test1() {
    int[] customers = {1,0,1,2,1,1,7,5};
    int[] grumpy = {0,1,0,1,0,1,0,1};
    int X = 3;
    Solution s = new Solution();
    int output = s.maxSatisfied(customers, grumpy, X);
    boolean passed = output == 16;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
