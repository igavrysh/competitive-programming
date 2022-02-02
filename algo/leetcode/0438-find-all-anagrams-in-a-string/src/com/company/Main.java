package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void test1() {
    String s = "cbaebabacd", p = "abc";
    Solution sol = new Solution();
    List<Integer> output = sol.findAnagrams(s, p);
    boolean passed = Arrays.deepEquals(output.toArray(), new Integer[]{0,6});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String s = "abab", p = "ab";
    Solution sol = new Solution();
    List<Integer> output = sol.findAnagrams(s, p);
    boolean passed = Arrays.deepEquals(output.toArray(), new Integer[]{0,1,2});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }
  public static void main(String[] args) {
    test1();
    test2();
  }
}
