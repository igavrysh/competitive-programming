package com.company;

import java.util.List;

public class Main {

  private static void test1() {
    char[][] board = new char[][]{
        new char[]{'o', 'a', 'a', 'n'},
        new char[]{'e', 't', 'a', 'e'},
        new char[]{'i', 'h', 'k', 'r'},
        new char[]{'i', 'f', 'l', 'v'}
    };

    Solution solution = new Solution();
    List<String> output = solution.findWords(
        board,
        new String[]{"oath", "pea", "eat", "rain"});


    boolean passed = output.contains("eat")
        && output.contains("oath");
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
