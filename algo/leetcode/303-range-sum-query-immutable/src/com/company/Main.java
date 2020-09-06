package com.company;

public class Main {

  private static void test1() {
    NumArray solution = new NumArray(new int[]{ -2, 0, 3, -5, 2, -1 });
    boolean passed = solution.sumRange(0, 2) == 1
        && solution.sumRange(2, 5) == -1
        && solution.sumRange(0, 5) == -3;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
