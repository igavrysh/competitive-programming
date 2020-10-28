package com.company;

public class Main {

  public static void test1() {
    int[] input = {3, 2, 2, 3};
    Solution s = new Solution();
    int output = s.removeElement(input, 3);
    boolean passed = output == 2
        && input[0] == 2
        && input[1] == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {0,1,2,2,3,0,4,2};
    Solution s = new Solution();
    int output = s.removeElement(input, 2);
    boolean passed = output == 5
        && input[0] == 0
        && input[1] == 1
        && input[2] == 3
        && input[3] == 0
        && input[4] == 4;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
