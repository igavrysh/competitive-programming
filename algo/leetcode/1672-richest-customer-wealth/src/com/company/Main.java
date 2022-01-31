package com.company;

public class Main {

  public static void test1() {
    int[][] accounts = {{1,2,3},{3,2,1}};
    Solution s = new Solution();
    int output = s.maximumWealth(accounts);
    boolean passed = output == 6;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] accounts = {{1,5},{7,3},{3,5}};
    Solution s = new Solution();
    int output = s.maximumWealth(accounts);
    boolean passed = output == 10;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }

}
