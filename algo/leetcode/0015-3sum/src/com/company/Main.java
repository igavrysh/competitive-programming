package com.company;

import java.util.Arrays;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.plaf.PanelUI;

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

  public static void test7() {
    SolutionOptimized s = new SolutionOptimized();
    List<List<Integer>> output = s.threeSum(new int[] {0, 0, 0, 0});
    output = output.stream().map(x -> { Collections.sort(x); return x; }).collect(Collectors.toList());
    boolean passed = output.size() == 1
        && output.contains(Arrays.asList(new Integer[]{0, 0, 0}));
    System.out.println("test7:" + (passed ? "passed" : "failed"));
  }

  public static void test8() {
    SolutionOptimized s = new SolutionOptimized();
    List<List<Integer>> output = s.threeSum(new int[] {1,-1,-1,0});
    output = output.stream().map(x -> { Collections.sort(x); return x; }).collect(Collectors.toList());
    boolean passed = output.size() == 1
        && output.contains(Arrays.asList(new Integer[]{-1, 0, 1}));
    System.out.println("test8:" + (passed ? "passed" : "failed"));
  }

  public static void test9() {
    SolutionOptimized s = new SolutionOptimized();
    List<List<Integer>> output = s.threeSum(new int[] {-1,0,1,0});
    output = output.stream().map(x -> { Collections.sort(x); return x; }).collect(Collectors.toList());
    boolean passed = output.size() == 1
        && output.contains(Arrays.asList(new Integer[]{-1, 0, 1}));
    System.out.println("test9:" + (passed ? "passed" : "failed"));
  }

  public static void test10() {
    SolutionOptimized s = new SolutionOptimized();
    List<List<Integer>> output = s.threeSum(new int[] {-2,0,1,1,2});
    output = output.stream().map(x -> { Collections.sort(x); return x; }).collect(Collectors.toList());
    boolean passed = output.size() == 2
        && output.contains(Arrays.asList(new Integer[]{-2, 0, 2}))
        && output.contains(Arrays.asList(new Integer[]{-2, 1, 1}));
    System.out.println("test10:" + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    SolutionOptimized s = new SolutionOptimized();
    List<List<Integer>> output = s.threeSum(new int[] {-1,0,1,2,-1,-4,-2,-3,3,0,4});
    output = output.stream().map(x -> { Collections.sort(x); return x; }).collect(Collectors.toList());
    boolean passed = output.size() == 9
        && output.contains(Arrays.asList(new Integer[]{-4, 0, 4}))
        && output.contains(Arrays.asList(new Integer[]{-4, 1, 3}))
        && output.contains(Arrays.asList(new Integer[]{-3, -1, 4}))
        && output.contains(Arrays.asList(new Integer[]{-3, 0, 3}))
        && output.contains(Arrays.asList(new Integer[]{-3, 1, 2}))
        && output.contains(Arrays.asList(new Integer[]{-2, -1, 3}))
        && output.contains(Arrays.asList(new Integer[]{-2, 0, 2}))
        && output.contains(Arrays.asList(new Integer[]{-1, -1, 2}))
        && output.contains(Arrays.asList(new Integer[]{-1, 0, 1}));
    System.out.println("test11:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {

    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
    test8();
    test9();
    test10();
    test11();
  }

}
