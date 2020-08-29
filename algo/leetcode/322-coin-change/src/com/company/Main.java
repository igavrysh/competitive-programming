package com.company;

public class Main {

  private static void test1() {
    Solution solution = new Solution();
    int output = solution.coinChange(new int[]{1, 2, 5}, 11);
    System.out.println("output:" + Integer.toString(output));
    boolean passed = output == 3;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    Solution solution = new Solution();
    int output = solution.coinChange(new int[]{1}, 0);
    boolean passed = output == 0;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    Solution solution = new Solution();
    int output = solution.coinChange(new int[]{186, 419, 83, 408}, 6249);
    System.out.println("test3 finished execution");
  }


  public static void main(String[] args) {
    //test1();
    //test2();
    test3();
  }
}
