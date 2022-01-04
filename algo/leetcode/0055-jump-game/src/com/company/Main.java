package com.company;

public class Main {

  public static void test1() {
    int[] input = new int[] { 2,3,1,1,4 };
    Solution solution = new Solution();
    boolean passed = solution.canJump(input) == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = new int[] { 3,2,1,0,4 };
    Solution solution = new Solution();
    boolean passed = solution.canJump(input) == false;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }


  public static void main(String[] args) {
    test1();
    test2();
  }
}
