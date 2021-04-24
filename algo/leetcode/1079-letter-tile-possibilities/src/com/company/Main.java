package com.company;

public class Main {

  public static void test1() {
    String input = "AAB";
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numTilePossibilities(input);
    boolean passed = output == 8;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String input = "AAABBC";
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numTilePossibilities(input);
    boolean passed = output == 188;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String input = "V";
    SolutionRecursive s = new SolutionRecursive();
    int output = s.numTilePossibilities(input);
    boolean passed = output == 1;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
