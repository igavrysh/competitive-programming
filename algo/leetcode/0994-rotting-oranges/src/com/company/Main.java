package com.company;

public class Main {

  private static void test1() {
    int [][] map = {
        {2,1,1},
        {1,1,0},
        {0,1,1}
    };
    Solution s = new Solution();
    int output = s.orangesRotting(map);
    boolean passed = output == 4;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    int [][] map = {
        {2,1,1},
        {0,1,1},
        {1,0,1}
    };
    Solution s = new Solution();
    int output = s.orangesRotting(map);
    boolean passed = output == -1;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    int [][] map = {
        {0,2}
    };
    Solution s = new Solution();
    int output = s.orangesRotting(map);
    boolean passed = output == 0;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    int [][] map = {
        {0,1}
    };
    Solution s = new Solution();
    int output = s.orangesRotting(map);
    boolean passed = output == -1;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
