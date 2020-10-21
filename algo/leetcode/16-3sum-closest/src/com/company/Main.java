package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.threeSumClosest(new int[] {-1,2,1,-4}, 1);
    boolean passed = output == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
