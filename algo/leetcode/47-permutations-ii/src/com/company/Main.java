package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void testRecursive1() {
    int[] input = {1,1,2};
    SolutionRecursiveFq s = new SolutionRecursiveFq();
    List<List<Integer>> output =  s.permuteUnique(input);
    boolean passed = output.size() == 3;
    for (List<Integer> l : output) {
      passed = passed && (l.equals(Arrays.asList(new Integer[]{1,1,2}))
          || l.equals(Arrays.asList(new Integer[]{1,2,1}))
          || l.equals(Arrays.asList(new Integer[]{2,1,1})));
    }
    System.out.println("testRecursiveFq1: " + (passed ? "passed" : "failed"));
  }

  public static void testRecursive2() {
    int[] input = {1,2,3};
    SolutionRecursiveFq s = new SolutionRecursiveFq();
    List<List<Integer>> output =  s.permuteUnique(input);
    boolean passed = output.size() == 6;
    for (List<Integer> l : output) {
      passed = passed
          && (l.equals(Arrays.asList(new Integer[]{1,2,3}))
            || l.equals(Arrays.asList(new Integer[]{1,3,2}))
            || l.equals(Arrays.asList(new Integer[]{2,1,3}))
            || l.equals(Arrays.asList(new Integer[]{2,3,1}))
            || l.equals(Arrays.asList(new Integer[]{3,1,2}))
            || l.equals(Arrays.asList(new Integer[]{3,2,1})));
    }
    System.out.println("testRecursiveFq2: " + (passed ? "passed" : "failed"));
  }

  public static void testRecursive3() {
    int[] input = {};
    SolutionRecursiveFq s = new SolutionRecursiveFq();
    List<List<Integer>> output =  s.permuteUnique(input);
    boolean passed = output.size() == 1 && output.get(0).size() == 0;
    System.out.println("testRecursiveFq3: " + (passed ? "passed" : "failed"));
  }

  public static void testRecursiveSort1() {
    int[] input = {1,1,2};
    SolutionRecursiveSort s = new SolutionRecursiveSort();
    List<List<Integer>> output =  s.permuteUnique(input);
    boolean passed = output.size() == 3;
    for (List<Integer> l : output) {
      passed = passed && (l.equals(Arrays.asList(new Integer[]{1,1,2}))
          || l.equals(Arrays.asList(new Integer[]{1,2,1}))
          || l.equals(Arrays.asList(new Integer[]{2,1,1})));
    }
    System.out.println("testRecursiveSort1: " + (passed ? "passed" : "failed"));
  }

  public static void testRecursiveSort2() {
    int[] input = {1,2,3};
    SolutionRecursiveFq s = new SolutionRecursiveFq();
    List<List<Integer>> output =  s.permuteUnique(input);
    boolean passed = output.size() == 6;
    for (List<Integer> l : output) {
      passed = passed
          && (l.equals(Arrays.asList(new Integer[]{1,2,3}))
            || l.equals(Arrays.asList(new Integer[]{1,3,2}))
            || l.equals(Arrays.asList(new Integer[]{2,1,3}))
            || l.equals(Arrays.asList(new Integer[]{2,3,1}))
            || l.equals(Arrays.asList(new Integer[]{3,1,2}))
            || l.equals(Arrays.asList(new Integer[]{3,2,1})));
    }
    System.out.println("testRecursiveSort2: " + (passed ? "passed" : "failed"));
  }

  public static void testRecursiveSort3() {
    int[] input = {};
    SolutionRecursiveFq s = new SolutionRecursiveFq();
    List<List<Integer>> output =  s.permuteUnique(input);
    boolean passed = output.size() == 1 && output.get(0).size() == 0;
    System.out.println("testRecursiveSort3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    testRecursive1();
    testRecursive2();
    testRecursive3();
    testRecursiveSort1();
    testRecursiveSort2();
    testRecursiveSort3();
  }
}
