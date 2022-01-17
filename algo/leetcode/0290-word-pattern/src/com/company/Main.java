package com.company;

public class Main {

  public static void test1() {
    String pattern = "abba", s = "dog cat cat dog";
    SolutionTwoHashMaps solutionTwoHashMaps = new SolutionTwoHashMaps();
    boolean output = solutionTwoHashMaps.wordPattern(pattern, s);
    boolean passed = output == true;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String pattern = "abba", s = "dog cat cat fish";
    SolutionTwoHashMaps solutionTwoHashMaps = new SolutionTwoHashMaps();
    boolean output = solutionTwoHashMaps.wordPattern(pattern, s);
    boolean passed = output == false;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    String pattern = "aaaa", s = "dog cat cat dog";
    SolutionTwoHashMaps solutionTwoHashMaps = new SolutionTwoHashMaps();
    boolean output = solutionTwoHashMaps.wordPattern(pattern, s);
    boolean passed = output == false;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    String pattern = "abba", s = "dog dog dog dog";
    SolutionTwoHashMaps solutionTwoHashMaps = new SolutionTwoHashMaps();
    boolean output = solutionTwoHashMaps.wordPattern(pattern, s);
    boolean passed = output == false;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
