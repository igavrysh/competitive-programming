package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    int k = 3;
    int[] arrival = {1,2,3,4,5}, load = {5,2,3,3,3};
    Solution s = new Solution();
    List<Integer> output = s.busiestServers(k, arrival, load);
    List<Integer> expectedOutput = Arrays.asList(new Integer[]{1});
    boolean passed = output.size() == expectedOutput.size();
    for (Integer i : expectedOutput) {
      passed = passed && output.contains(i);
    }
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int k = 3;
    int[] arrival = {1,2,3,4}, load = {1,2,1,2};
    Solution s = new Solution();
    List<Integer> output = s.busiestServers(k, arrival, load);
    List<Integer> expectedOutput = Arrays.asList(new Integer[]{0});
    boolean passed = output.size() == expectedOutput.size();
    for (Integer i : expectedOutput) {
      passed = passed && output.contains(i);
    }
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int k = 3;
    int[] arrival = {1,2,3}, load = {10,12,11};
    Solution s = new Solution();
    List<Integer> output = s.busiestServers(k, arrival, load);
    List<Integer> expectedOutput = Arrays.asList(new Integer[]{0,1,2});
    boolean passed = output.size() == expectedOutput.size();
    for (Integer i : expectedOutput) {
      passed = passed && output.contains(i);
    }
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
