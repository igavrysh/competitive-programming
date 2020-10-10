package com.company;

public class Main {

  public static void test1() {
    char[][] input = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };
    Solution s = new Solution();
    int output = s.numIslands(input);
    boolean passed = output == 1;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    char[][] input = {
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}
    };
    Solution s = new Solution();
    int output = s.numIslands(input);
    boolean passed = output == 3;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    char[][] input = {
        {'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}
    };
    Solution s = new Solution();
    int output = s.numIslands(input);
    boolean passed = output == 3;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    char[][] input = {
        {'1'},
        {'1'}
    };
    Solution s = new Solution();
    int output = s.numIslands(input);
    boolean passed = output == 1;;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    //test1();
    //test2();
    //test3();
    test4();
  }
}
