package com.company;

import java.util.List;

public class Main {

  public static void test1() {
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
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String[] input = {""};
    Solution s = new Solution();
    List<List<String>> output = s.groupAnagrams(input);
    boolean passed = output.size() == 1;
    for (List<String> o : output) {
      passed = passed && o.contains("");
    }
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String[] input = {"a"};
    Solution s = new Solution();
    List<List<String>> output = s.groupAnagrams(input);
    boolean passed = output.size() == 1;
    for (List<String> o : output) {
      passed = passed && o.contains("a");
    }
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
