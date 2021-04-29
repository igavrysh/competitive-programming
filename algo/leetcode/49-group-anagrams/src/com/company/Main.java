package com.company;

import java.util.List;

public class Main {

  public static void test01() {
    String[] input = {"eat","tea","tan","ate","nat","bat"};
    Solution s = new Solution();
    List<List<String>> output = s.groupAnagrams(input);
    boolean passed = output.size() == 3;
    for (List<String> o : output) {
      passed = passed
          && (
          (o.contains("eat") && o.contains("tea") && o.contains("ate"))
              || (o.contains("bat"))
              || (o.contains("nat")) && o.contains("tan"));
    }
    System.out.println("test01: " + (passed ? "passed" : "failed"));
  }

  public static void test02() {
    String[] input = {""};
    Solution s = new Solution();
    List<List<String>> output = s.groupAnagrams(input);
    boolean passed = output.size() == 1;
    for (List<String> o : output) {
      passed = passed && o.contains("");
    }
    System.out.println("test02: " + (passed ? "passed" : "failed"));
  }

  public static void test03() {
    String[] input = {"a"};
    Solution s = new Solution();
    List<List<String>> output = s.groupAnagrams(input);
    boolean passed = output.size() == 1;
    for (List<String> o : output) {
      passed = passed && o.contains("a");
    }
    System.out.println("test03: " + (passed ? "passed" : "failed"));
  }

  public static void test11() {
    String[] input = {"eat","tea","tan","ate","nat","bat"};
    SolutionOptimized s = new SolutionOptimized();
    List<List<String>> output = s.groupAnagrams(input);
    boolean passed = output.size() == 3;
    for (List<String> o : output) {
      passed = passed
          && (
              (o.contains("eat") && o.contains("tea") && o.contains("ate"))
                  || (o.contains("bat"))
                  || (o.contains("nat")) && o.contains("tan"));
    }
    System.out.println("test11: " + (passed ? "passed" : "failed"));
  }

  public static void test12() {
    String[] input = {""};
    SolutionOptimized s = new SolutionOptimized();
    List<List<String>> output = s.groupAnagrams(input);
    boolean passed = output.size() == 1;
    for (List<String> o : output) {
      passed = passed && o.contains("");
    }
    System.out.println("test12: " + (passed ? "passed" : "failed"));
  }

  public static void test13() {
    String[] input = {"a"};
    SolutionOptimized s = new SolutionOptimized();
    List<List<String>> output = s.groupAnagrams(input);
    boolean passed = output.size() == 1;
    for (List<String> o : output) {
      passed = passed && o.contains("a");
    }
    System.out.println("test13: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test01();
    test02();
    test03();
    test11();
    test12();
    test13();
  }
}
