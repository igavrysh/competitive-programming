package com.company;

public class Main {

  private static void test1() {
    int[] input = new int[] { 1,1,2 };
    Solution s = new Solution();
    int output = s.removeDuplicates(input);
    boolean passed = output == 2
        && input[0] == 1
        && input[1] == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    int[] input = new int[] { 0,0,1,1,1,2,2,3,3,4 };
    Solution s = new Solution();
    int output = s.removeDuplicates(input);
    boolean passed = output == 5
        && input[0] == 0
        && input[1] == 1
        && input[2] == 2
        && input[3] == 3
        && input[4] == 4;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
