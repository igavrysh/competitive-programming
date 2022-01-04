package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int[] output = s.intersect(new int[] {1,2,2,1}, new int[] {2,2});
    boolean passed = output.length == 2
        && output[0] == 2
        && output[1] == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int[] output = s.intersect(new int[] {4, 9, 5}, new int[] {9,4,9,8,4});
    boolean passed = output.length == 2
        && output[0] == 4
        && output[1] == 9;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
