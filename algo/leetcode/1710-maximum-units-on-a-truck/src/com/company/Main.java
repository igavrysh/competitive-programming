package com.company;

public class Main {

  public static void test1() {
    int[][] boxTypes = {{1,3},{2,2},{3,1}};
    int truckSize = 4;
    Solution s = new Solution();
    int output = s.maximumUnits(boxTypes, truckSize);
    boolean passed = output == 8;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}};
    int truckSize = 10;
    Solution s = new Solution();
    int output = s.maximumUnits(boxTypes, truckSize);
    boolean passed = output == 91;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] boxTypes = {{1,3},{5,5},{2,5},{4,2},{4,1},{3,1},{2,2},{1,3},{2,5},{3,2}};
    int truckSize = 35;
    Solution s = new Solution();
    int output = s.maximumUnits(boxTypes, truckSize);
    boolean passed = output == 76;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
