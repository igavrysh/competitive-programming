package com.company;

public class Main {

  private static void test1() {
    int[][] times = {{2,1,1}, {2,3,1}, {3,4,1}};
    int N = 4;
    int K = 2;
    Solution s = new Solution();
    int output = s.networkDelayTime(times, N, K);
    boolean passed = output == 2;
    System.out.println("test1:" + (passed ? "true" : "false"));
  }

  private static void test2() {
    int[][] times = {{1,2,1}};
    int N = 2;
    int K = 2;
    Solution s = new Solution();
    int output = s.networkDelayTime(times, N, K);
    boolean passed = output == -1;
    System.out.println("test2:" + (passed ? "true" : "false"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }

}
