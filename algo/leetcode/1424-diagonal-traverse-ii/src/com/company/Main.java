package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  private static void test1() {
    List<List<Integer>> input = List.of(
        Arrays.<Integer>asList(new Integer[]{1,2,3}),
        Arrays.<Integer>asList(new Integer[]{4,5,6}),
        Arrays.<Integer>asList(new Integer[]{7,8,9}));
    Solution s = new Solution();
    int[] output = s.findDiagonalOrder(input);
    List<Integer> baseline = Arrays.asList(new Integer[]{1,4,2,7,5,3,8,6,9});
    List<Integer> candidate = Arrays.stream(output).boxed().collect(Collectors.toList());
    boolean passed = candidate.equals(baseline);
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    List<List<Integer>> input = List.of(
        Arrays.<Integer>asList(new Integer[]{1,2,3,4,5}),
        Arrays.<Integer>asList(new Integer[]{6,7}),
        Arrays.<Integer>asList(new Integer[]{8}),
        Arrays.<Integer>asList(new Integer[]{9,10,11}),
        Arrays.<Integer>asList(new Integer[]{12,13,14,15,16}));
    Solution s = new Solution();
    int[] output = s.findDiagonalOrder(input);
    List<Integer> baseline = Arrays.asList(new Integer[]{1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16});
    List<Integer> candidate = Arrays.stream(output).boxed().collect(Collectors.toList());
    boolean passed = candidate.equals(baseline);
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    List<List<Integer>> input = List.of(
        Arrays.<Integer>asList(new Integer[]{1,2,3}),
        Arrays.<Integer>asList(new Integer[]{4}),
        Arrays.<Integer>asList(new Integer[]{5,6,7}),
        Arrays.<Integer>asList(new Integer[]{8}),
        Arrays.<Integer>asList(new Integer[]{9,10,11}));
    Solution s = new Solution();
    int[] output = s.findDiagonalOrder(input);
    List<Integer> baseline = Arrays.asList(
        new Integer[]{1,4,2,5,3,8,6,9,7,10,11});
    List<Integer> candidate = Arrays.stream(output).boxed().collect(Collectors.toList());
    boolean passed = candidate.equals(baseline);
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    List<List<Integer>> input = List.of(
        Arrays.<Integer>asList(new Integer[]{1,2,3, 4, 5, 6}));
    Solution s = new Solution();
    int[] output = s.findDiagonalOrder(input);
    List<Integer> baseline = Arrays.asList(
        new Integer[]{1,2,3,4,5,6});
    List<Integer> candidate = Arrays.stream(output).boxed().collect(Collectors.toList());
    boolean passed = candidate.equals(baseline);
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
