package com.company;

public class Main {

  private static void test1() {
    SolutionRecursiveNaive s = new SolutionRecursiveNaive();
    int output = s.maxCoins(new int[] {3,1,5,8});
    boolean passed = output == 167;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    SolutionIterativeDP s = new SolutionIterativeDP();
    int output = s.maxCoins(new int[] {3,1,5,8});
    boolean passed = output == 167;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    SolutionIterativeDP s = new SolutionIterativeDP();
    int output = s.maxCoins(new int[] {35,16,83,87,84,59,48,41,20,54});
    boolean passed = output == 167;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    //test1();
    test2();
   // test3();
  }
}
