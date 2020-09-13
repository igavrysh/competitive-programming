package com.company;

public class Main {

  public static void test1() {
    char[] tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
    int n = 2;
    Solution s = new Solution();
    boolean passed = s.leastInterval(tasks, n) == 8;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
