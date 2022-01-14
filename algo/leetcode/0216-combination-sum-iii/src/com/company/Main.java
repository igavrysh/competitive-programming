package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    int k = 3;
    int n = 7;
    SolutionII s = new SolutionII();
    List<List<Integer>> result = s.combinationSum3(k, n);
    boolean passed = result.size() == 1
        && Arrays.equals(result.get(0).toArray(new Integer[result.size()]), new Integer[] {1, 2, 4});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int k = 3;
    int n = 9;
    Solution s = new Solution();
    List<List<Integer>> result = s.combinationSum3(k, n);
    boolean passed = result.size() == 3
        && result.stream()
        .map(l -> l.toArray(new Integer[l.size()]))
        .map(a ->
            Arrays.equals(a, new Integer[] { 1, 2, 6 } )
            || Arrays.equals(a, new Integer[] { 1, 3, 5 })
            || Arrays.equals(a, new Integer[] { 2, 3, 4 }))
        .reduce(true, (res, elem) -> res && elem);
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int k = 4;
    int n = 1;
    Solution s = new Solution();
    List<List<Integer>> result = s.combinationSum3(k, n);
    boolean passed = result.size() == 0;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int k = 3;
    int n = 2;
    Solution s = new Solution();
    List<List<Integer>> result = s.combinationSum3(k, n);
    boolean passed = result.size() == 0;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int k = 9;
    int n = 45;
    Solution s = new Solution();
    List<List<Integer>> result = s.combinationSum3(k, n);
    boolean passed = result.size() == 1
        && Arrays.equals(result.get(0).toArray(new Integer[result.size()]), new Integer[] {1,2,3,4,5,6,7,8,9});
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }
}
