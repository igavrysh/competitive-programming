package com.company;

import java.util.List;

public class Main {

  private static void test1() {
    Solution solution = new Solution();
    char[][] board = new char[][] {
        {'o','a','a','n'},
        {'e','t','a','e'},
        {'i','h','k','r'},
        {'i','f','l','v'}
    };
    String[] words = new String[] {"oath","pea","eat","rain"};
    List<String> output = solution.findWords(board, words);
    boolean passed = output.contains("eat")
        && output.contains("oath")
        && output.size() == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    Solution solution = new Solution();
    char[][] board = new char[][] {
        {'b','b','a','a','b','a'},
        {'b','b','a','b','a','a'},
        {'b','b','b','b','b','b'},
        {'a','a','a','b','a','a'},
        {'a','b','a','a','b','b'}
    };
    String[] words = new String[] {"abbbababaa"};
    List<String> output = solution.findWords(board, words);
    boolean passed = output.contains("eat")
        && output.contains("oath")
        && output.size() == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));

  }

  public static void main(String[] args) {
    test2();
  }
}
