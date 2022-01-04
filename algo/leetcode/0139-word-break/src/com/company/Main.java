package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {
    SolutionIterative s = new SolutionIterative();
    boolean output = s.wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"}));
    boolean passed = output == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    SolutionIterative s = new SolutionIterative();
    boolean output = s.wordBreak("applepenapple", Arrays.asList("apple", "pen"));
    boolean passed = output == true;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    SolutionIterative s = new SolutionIterative();
    boolean output = s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
    boolean passed = output == false;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    SolutionIterative s = new SolutionIterative();
    boolean output = s.wordBreak(
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
        Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}));
    boolean passed = output == false;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    SolutionIterative s = new SolutionIterative();
    boolean output = s.wordBreak(
        "a",
        Arrays.asList(new String[]{"a"}));
    boolean passed = output == true;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }
}
