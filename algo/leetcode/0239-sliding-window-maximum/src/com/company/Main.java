package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {
    int[] nums = {1,3,-1,-3,5,3,6,7};
    int k = 3;
    SolutionMonotonicQueue s = new SolutionMonotonicQueue();
    int[] output = s.maxSlidingWindow(nums, k);
    boolean passed = Arrays.equals(output, new int[]{3,3,5,5,6,7});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    int[] nums = {1,3,-1,-3,5,3,6,7};
    int k = 3;
    SolutionDP s = new SolutionDP();
    int[] output = s.maxSlidingWindow(nums, k);
    boolean passed = Arrays.equals(output, new int[]{3,3,5,5,6,7});
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }


  public static void test2() {
    int[] nums = {1,3,1,2,0,5};
    int k = 3;
    SolutionMonotonicQueue s = new SolutionMonotonicQueue();
    int[] output = s.maxSlidingWindow(nums, k);
    boolean passed = Arrays.equals(output, new int[]{3,3,2,5});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test21() {
    int[] nums = {1,3,1,2,0,5};
    int k = 3;
    SolutionDP s = new SolutionDP();
    int[] output = s.maxSlidingWindow(nums, k);
    boolean passed = Arrays.equals(output, new int[]{3,3,2,5});
    System.out.println("test21: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test11();
    test2();
    test21();
  }
}
