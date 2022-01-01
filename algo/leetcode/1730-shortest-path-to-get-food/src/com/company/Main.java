package com.company;

public class Main {

  public static void test1() {
    char[][] grid = {
        {'X','X','X','X','X','X'},
        {'X','*','O','O','O','X'},
        {'X','O','O','#','O','X'},
        {'X','X','X','X','X','X'}
    };
    Solution s = new Solution();
    int output = s.getFood(grid);
    boolean passed = output == 3;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    char[][] grid = {
        {'X','X','X','X','X'},
        {'X','*','X','O','X'},
        {'X', 'O','X','#','X'},
        {'X','X','X','X','X'}};
    Solution s = new Solution();
    int output = s.getFood(grid);
    boolean passed = output == -1;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    char[][] grid = {
        {'X','X','X','X','X','X','X','X'},
        {'X','*','O','X','O','#','O','X'},
        {'X','O','O','X','O','O','X','X'},
        {'X','O','O','O','O','#','O','X'},
        {'X','X','X','X','X','X','X','X'}
    };
    Solution s = new Solution();
    int output = s.getFood(grid);
    boolean passed = output == 6;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
