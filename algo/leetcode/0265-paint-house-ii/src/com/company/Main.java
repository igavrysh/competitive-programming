package com.company;

public class Main {

  public static void test1() {
    int[][] costs = {{1,5,3},{2,9,4}};
    int expOutput = 5;
    Solution s = new Solution();
    int output = s.minCostII(costs);
    boolean passed = expOutput == output;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] costs = {{1,3},{2,4}};
    int expOutput = 5;
    Solution s = new Solution();
    int output = s.minCostII(costs);
    boolean passed = expOutput == output;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] costs = {
        {20,19,11,13,12,16,16,17,15,9,5,18},
        {3,8,15,17,19,8,18,3,11,6,7,12},
        {15,4,11,1,18,2,10,9,3,6,4,15}
    };
    int expOutput = 9;
    Solution s = new Solution();
    int output = s.minCostII(costs);
    boolean passed = expOutput == output;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[][] costs = {
        {11,20,4,3,19,3,18,17,6,8,18,18},
        {6,14,13,4,8,12,16,4,14,15,11,12},
        {8,1,4,20,19,9,12,11,13,12,1,3},
        {8,12,9,3,1,14,3,16,12,13,4,10},
        {17,1,1,5,17,10,20,15,3,9,18,3},
        {16,3,18,11,1,16,3,10,19,6,11,13}
    };
    int expOutput = 11;
    Solution s = new Solution();
    int output = s.minCostII(costs);
    boolean passed = expOutput == output;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    //test1();
    //test2();
    //test3();
    test4();
  }
}
