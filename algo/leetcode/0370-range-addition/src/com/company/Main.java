package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {
    int length = 5;
    int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
    Solution s = new Solution();
    int[] output = s.getModifiedArray(length, updates);
    boolean passed = Arrays.equals(output, new int[]{-2,0,3,5,3});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
