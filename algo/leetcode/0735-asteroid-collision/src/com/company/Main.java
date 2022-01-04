package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {
    int[] asteroids = {5,10,-5};
    Solution s = new Solution();
    int[] output = s.asteroidCollision(asteroids);
    boolean passed = Arrays.equals(output, new int[]{5,10});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] asteroids = {8,-8};
    Solution s = new Solution();
    int[] output = s.asteroidCollision(asteroids);
    boolean passed = Arrays.equals(output, new int[]{});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] asteroids = {10,2,-5};
    Solution s = new Solution();
    int[] output = s.asteroidCollision(asteroids);
    boolean passed = Arrays.equals(output, new int[]{10});
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] asteroids = {-2,-1,1,2};
    Solution s = new Solution();
    int[] output = s.asteroidCollision(asteroids);
    boolean passed = Arrays.equals(output, new int[]{-2,-1,1,2});
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
