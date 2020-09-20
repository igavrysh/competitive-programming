package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    boolean passed = s.canJump(new int[] { 2,3,1,1,4} ) == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    boolean passed = s.canJump(new int[] { 3,2,1,0,4 } ) == false;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
