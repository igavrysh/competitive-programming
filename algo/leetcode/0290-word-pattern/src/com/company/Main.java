package com.company;

public class Main {

  public static void testSolutionTwoHashMaps1() {
    String pattern = "abba", s = "dog cat cat dog";
    SolutionTwoHashMaps solutionTwoHashMaps = new SolutionTwoHashMaps();
    boolean output = solutionTwoHashMaps.wordPattern(pattern, s);
    boolean passed = output == true;
    System.out.println("testSolutionTwoHashMaps1: " + (passed ? "passed" : "failed"));
  }

  public static void testSolutionTwoHashMaps2() {
    String pattern = "abba", s = "dog cat cat fish";
    SolutionTwoHashMaps solutionTwoHashMaps = new SolutionTwoHashMaps();
    boolean output = solutionTwoHashMaps.wordPattern(pattern, s);
    boolean passed = output == false;
    System.out.println("testSolutionTwoHashMaps2: " + (passed ? "passed" : "failed"));
  }

  public static void testSolutionTwoHashMaps3() {
    String pattern = "aaaa", s = "dog cat cat dog";
    SolutionTwoHashMaps solutionTwoHashMaps = new SolutionTwoHashMaps();
    boolean output = solutionTwoHashMaps.wordPattern(pattern, s);
    boolean passed = output == false;
    System.out.println("testSolutionTwoHashMaps3: " + (passed ? "passed" : "failed"));
  }

  public static void testSolutionTwoHashMaps4() {
    String pattern = "abba", s = "dog dog dog dog";
    SolutionTwoHashMaps solutionTwoHashMaps = new SolutionTwoHashMaps();
    boolean output = solutionTwoHashMaps.wordPattern(pattern, s);
    boolean passed = output == false;
    System.out.println("testSolutionTwoHashMaps4: " + (passed ? "passed" : "failed"));
  }

  public static void testSolutionOneHashMap1() {
    String pattern = "abba", s = "dog a a dog";
    SolutionTwoHashMaps solutionTwoHashMaps = new SolutionTwoHashMaps();
    boolean output = solutionTwoHashMaps.wordPattern(pattern, s);
    boolean passed = output == true;
    System.out.println("testSolutionOneHashMap1: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    testSolutionTwoHashMaps1();
    testSolutionTwoHashMaps2();
    testSolutionTwoHashMaps3();
    testSolutionTwoHashMaps4();

    testSolutionOneHashMap1();
  }
}
