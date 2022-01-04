package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    String s = "catsanddog";
    List<String> wordDict = Arrays.asList(new String[] {"cat", "cats", "and", "sand", "dog"} );
    Solution solution = new Solution();
    List<String> output = solution.wordBreak(s, wordDict);
    boolean passed = output.size() == 2
        && output.contains("cat sand dog")
        && output.contains("cats and dog");
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String s = "pineapplepenapple";
    List<String> wordDict = Arrays.asList(new String[] {"apple", "pen", "applepen", "pine", "pineapple"} );
    Solution solution = new Solution();
    List<String> output = solution.wordBreak(s, wordDict);
    boolean passed = output.size() == 3
        && output.contains("pine apple pen apple")
        && output.contains("pineapple pen apple")
        && output.contains("pine applepen apple");
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String s = "catsandog";
    List<String> wordDict = Arrays.asList(new String[] {"cats", "dog", "sand", "and", "cat"} );
    Solution solution = new Solution();
    List<String> output = solution.wordBreak(s, wordDict);
    boolean passed = output.size() == 0;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    String s = "a";
    List<String> wordDict = Arrays.asList(new String[] {} );
    Solution solution = new Solution();
    List<String> output = solution.wordBreak(s, wordDict);
    boolean passed = output.size() == 0;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    String s = "a";
    List<String> wordDict = Arrays.asList(new String[] {"a"} );
    Solution solution = new Solution();
    List<String> output = solution.wordBreak(s, wordDict);
    boolean passed = output.size() == 1
        && output.contains("a");
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
