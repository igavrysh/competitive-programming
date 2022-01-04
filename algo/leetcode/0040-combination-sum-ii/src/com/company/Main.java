package com.company;

import java.util.List;

public class Main {

  public static void test1() {
    int[] input = {10,1,2,7,6,1,5};
    SolutionRecursive s = new SolutionRecursive();
    List<List<Integer>> output = s.combinationSum2(input, 8);
    boolean passed = output.size() == 4;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {2,5,2,1,2};
    SolutionRecursive s = new SolutionRecursive();
    List<List<Integer>> output = s.combinationSum2(input, 5);
    boolean passed = output.size() == 2;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] input = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    SolutionRecursive s = new SolutionRecursive();
    List<List<Integer>> output = s.combinationSum2(input, 27);
    boolean passed = output.size() == 1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] input = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    SolutionRecursive s = new SolutionRecursive();
    List<List<Integer>> output = s.combinationSum2(input, 27);
    boolean passed = output.size() == 1;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
