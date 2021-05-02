package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {
    int[][] input = {{1,3},{2,6},{8,10},{15,18}};
    Solution s = new Solution();
    int[][] output = s.merge(input);
    boolean passed = output.length == 3
       && Arrays.deepEquals(output, new int[][] {{1,6},{8,10},{15,18}});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] input = {{1,4},{4,5}};
    Solution s = new Solution();
    int[][] output = s.merge(input);
    boolean passed = output.length == 1
        && Arrays.deepEquals(output, new int[][] {{1,5}});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
