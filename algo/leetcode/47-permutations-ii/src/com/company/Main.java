package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    int[] input = {1,1,2};
    SolutionRecursive s = new SolutionRecursive();
    List<List<Integer>> output =  s.permuteUnique(input);
    boolean passed = output.size() == 3;
    for (List<Integer> l : output) {
      passed = passed && (l.equals(Arrays.asList(new Integer[]{1,1,2}))
          || l.equals(Arrays.asList(new Integer[]{1,2,1}))
          || l.equals(Arrays.asList(new Integer[]{2,1,1})));
    }
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {1,2,3};
    SolutionRecursive s = new SolutionRecursive();
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
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] input = {};
    SolutionRecursive s = new SolutionRecursive();
    List<List<Integer>> output =  s.permuteUnique(input);
    boolean passed = output.size() == 1 && output.get(0).size() == 0;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
