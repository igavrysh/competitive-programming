package com.company;

import java.util.Arrays;

public class Main {

  private static void test1() {
    int numCourses = 2;
    int[][] prerequisites = {{1,0}};
    Solution s = new Solution();
    int[] output = s.findOrder(numCourses, prerequisites);
    boolean passed = Arrays.equals(output, new int[]{0,1});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    int numCourses = 4;
    int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
    Solution s = new Solution();
    int[] output = s.findOrder(numCourses, prerequisites);
    boolean passed = Arrays.equals(output, new int[]{0,2,1,3});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
