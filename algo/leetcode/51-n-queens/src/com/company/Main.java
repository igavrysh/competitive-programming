package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  private static void test1() {
    Solution s = new Solution();
    List<List<String>> output = s.solveNQueens(1);
    boolean passed = output.size() == 1
        && output.get(0).size() == 1
        && output.get(0).get(0).equals("Q");
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    Solution s = new Solution();
    List<List<String>> output = s.solveNQueens(2);
    boolean passed = output.size() == 0;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    Solution s = new Solution();
    List<List<String>> output = s.solveNQueens(3);
    boolean passed = output.size() == 0;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    Solution s = new Solution();
    List<List<String>> output = s.solveNQueens(4);
    boolean passed = output.size() == 2;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  private static void test8() {
    Solution s = new Solution();
    List<List<String>> output = s.solveNQueens(8);
    boolean passed = output.size() == 2;
    System.out.println("test8: " + (passed ? "passed" : "failed"));
  }

  private static void testArraysHash1() {
    int[] t1 = {99,100,99,100};
    int hashT1 = Arrays.hashCode(t1);

    int[] t2 = {99,100,99,100};
    int hashT2 = Arrays.hashCode(t2);

    System.out.println("testArraysHash1: hashT1 == hashT2 ? " + (hashT1 == hashT2 ? "true" : "false") );
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test8();
    testArraysHash1();
  }
}
