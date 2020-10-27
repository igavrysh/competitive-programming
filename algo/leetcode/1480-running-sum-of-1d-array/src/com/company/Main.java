package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {
    int[] input = {1,2,3,4};
    Solution s = new Solution();
    int[] output = s.runningSum(input);
    boolean passed = Arrays.equals(output, new int[] {1,3,6,10});
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
