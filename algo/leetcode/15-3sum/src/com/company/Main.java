package com.company;

import java.util.Arrays;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

//  Input: nums = []
//  Output: [[-1,-1,2],[-1,0,1]]

  public static void test1() {
    Solution s = new Solution();
    List<List<Integer>> output = s.threeSum(new int[] {-1,0,1,2,-1,-4});
    output = output.stream().map(x -> { Collections.sort(x); return x; }).collect(Collectors.toList());
    boolean passed = output.size() == 2
        && output.contains(Arrays.asList(new Integer[]{-1, -1, 2}))
        && output.contains(Arrays.asList(new Integer[]{-1, 0, 1}));
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    List<List<Integer>> output = s.threeSum(new int[] {});
    output = output.stream().map(x -> { Collections.sort(x); return x; }).collect(Collectors.toList());
    boolean passed = output.size() == 0;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    List<List<Integer>> output = s.threeSum(new int[] {0});
    output = output.stream().map(x -> { Collections.sort(x); return x; }).collect(Collectors.toList());
    boolean passed = output.size() == 0;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    SolutionOptimized s = new SolutionOptimized();
    List<List<Integer>> output = s.threeSum(new int[] {-1,0,1,2,-1,-4});
    output = output.stream().map(x -> { Collections.sort(x); return x; }).collect(Collectors.toList());
    boolean passed = output.size() == 2
        && output.contains(Arrays.asList(new Integer[]{-1, -1, 2}))
        && output.contains(Arrays.asList(new Integer[]{-1, 0, 1}));
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    SolutionOptimized s = new SolutionOptimized();
    List<List<Integer>> output = s.threeSum(new int[] {});
    output = output.stream().map(x -> { Collections.sort(x); return x; }).collect(Collectors.toList());
    boolean passed = output.size() == 0;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    SolutionOptimized s = new SolutionOptimized();
    List<List<Integer>> output = s.threeSum(new int[] {0});
    output = output.stream().map(x -> { Collections.sort(x); return x; }).collect(Collectors.toList());
    boolean passed = output.size() == 0;
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }


  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
  }

}
