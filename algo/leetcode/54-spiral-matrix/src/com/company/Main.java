package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
    Solution s = new Solution();
    List<Integer> output = s.spiralOrder(input);
    boolean passed = output.size() == input.length * input[0].length
        && Arrays.equals(
            (Integer[])output.toArray(new Integer[output.size()]),
            new Integer[] {1,2,3,6,9,8,7,4,5});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    Solution s = new Solution();
    List<Integer> output = s.spiralOrder(input);
    boolean passed = output.size() == input.length * input[0].length
        && Arrays.equals(
        (Integer[])output.toArray(new Integer[output.size()]),
        new Integer[] {1,2,3,4,8,12,11,10,9,5,6,7});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[][] input = {{1}};
    Solution s = new Solution();
    List<Integer> output = s.spiralOrder(input);
    boolean passed = output.size() == input.length * input[0].length
        && Arrays.equals(
        (Integer[])output.toArray(new Integer[output.size()]),
        new Integer[] {1});
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
