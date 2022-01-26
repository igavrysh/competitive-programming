package com.company;

public class Main {

  public static void testSolutionDPBruteForce1() {
    char[][] input = {
        {'1','0','1','0','0'},
        {'1','0','1','1','1'},
        {'1','1','1','1','1'},
        {'1','0','0','1','0'}
    };
    SolutionDPBruteForce s = new SolutionDPBruteForce();
    int output = s.maximalRectangle(input);
    boolean passed = output == 6;
    System.out.println("testSolutionDPBruteForce1: " + (passed ? "passed" : "failed"));
  }

  public static void testSolutionDPBruteForce2() {
    char[][] input = {
        {'0'}
    };
    SolutionDPBruteForce s = new SolutionDPBruteForce();
    int output = s.maximalRectangle(input);
    boolean passed = output == 0;
    System.out.println("testSolutionDPBruteForce2: " + (passed ? "passed" : "failed"));
  }

  public static void testSolutionDPBruteForce3() {
    char[][] input = {
        {'1'}
    };
    SolutionDPBruteForce s = new SolutionDPBruteForce();
    int output = s.maximalRectangle(input);
    boolean passed = output == 1;
    System.out.println("testSolutionDPBruteForce3: " + (passed ? "passed" : "failed"));
  }

  public static void testSolutionDP1() {
    char[][] input = {
        {'1','0','1','0','0'},
        {'1','0','1','1','1'},
        {'1','1','1','1','1'},
        {'1','0','0','1','0'}
    };
    SolutionDP s = new SolutionDP();
    int output = s.maximalRectangle(input);
    boolean passed = output == 6;
    System.out.println("testSolutionDP1: " + (passed ? "passed" : "failed"));
  }

  public static void testSolutionDP2() {
    char[][] input = {
        {'0'}
    };
    SolutionDP s = new SolutionDP();
    int output = s.maximalRectangle(input);
    boolean passed = output == 0;
    System.out.println("testSolutionDP2: " + (passed ? "passed" : "failed"));
  }

  public static void testSolutionDP3() {
    char[][] input = {
        {'1'}
    };
    SolutionDP s = new SolutionDP();
    int output = s.maximalRectangle(input);
    boolean passed = output == 1;
    System.out.println("testSolutionDP3: " + (passed ? "passed" : "failed"));
  }

  public static void testSolutionDP4() {
    char[][] input = {
        {'0','1','1','0','1'},
        {'1','1','0','1','0'},
        {'0','1','1','1','0'},
        {'1','1','1','1','0'},
        {'1','1','1','1','1'},
        {'0','0','0','0','0'}
    };
    SolutionDP s = new SolutionDP();
    int output = s.maximalRectangle(input);
    boolean passed = output == 9;
    System.out.println("testSolutionDP4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    testSolutionDPBruteForce1();
    testSolutionDPBruteForce2();
    testSolutionDPBruteForce3();
    testSolutionDP1();
    testSolutionDP2();
    testSolutionDP3();
    testSolutionDP4();
  }
}
