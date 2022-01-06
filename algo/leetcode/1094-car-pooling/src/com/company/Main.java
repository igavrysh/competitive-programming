package com.company;

public class Main {

  public static void testPQ1() {
    int[][] trips = {{2,1,5},{3,3,7}};
    int capacity = 4;
    SolutionPQ s = new SolutionPQ();
    boolean output = s.carPooling(trips, capacity);
    boolean passed = output == false;
    System.out.println("testPQ1: " + (passed ? "passed" : "failed"));
  }

  public static void testPQ2() {
    int[][] trips = {{2,1,5},{3,3,7}};
    int capacity = 5;
    SolutionPQ s = new SolutionPQ();
    boolean output = s.carPooling(trips, capacity);
    boolean passed = output == true;
    System.out.println("testPQ2: " + (passed ? "passed" : "failed"));
  }

  public static void testPQ3() {
    int[][] trips = {{5,7,8},{10,2,3},{8,3,9},{3,2,5},{7,4,9},{4,7,8},{3,7,9},{3,3,9}};
    int capacity = 29;
    SolutionPQ s = new SolutionPQ();
    boolean output = s.carPooling(trips, capacity);
    boolean passed = output == false;
    System.out.println("testPQ3: " + (passed ? "passed" : "failed"));
  }

  public static void testPQImprv1() {
    int[][] trips = {{2,1,5},{3,3,7}};
    int capacity = 4;
    SolutionPQImprv s = new SolutionPQImprv();
    boolean output = s.carPooling(trips, capacity);
    boolean passed = output == false;
    System.out.println("testPQImprv1: " + (passed ? "passed" : "failed"));
  }

  public static void testPQImprv2() {
    int[][] trips = {{2,1,5},{3,3,7}};
    int capacity = 5;
    SolutionPQImprv s = new SolutionPQImprv();
    boolean output = s.carPooling(trips, capacity);
    boolean passed = output == true;
    System.out.println("testPQImprv2: " + (passed ? "passed" : "failed"));
  }

  public static void testPQImprv3() {
    int[][] trips = {{5,7,8},{10,2,3},{8,3,9},{3,2,5},{7,4,9},{4,7,8},{3,7,9},{3,3,9}};
    int capacity = 29;
    SolutionPQImprv s = new SolutionPQImprv();
    boolean output = s.carPooling(trips, capacity);
    boolean passed = output == false;
    System.out.println("testPQImprv3: " + (passed ? "passed" : "failed"));
  }

  public static void testAcc1() {
    int[][] trips = {{2,1,5},{3,3,7}};
    int capacity = 4;
    SolutionAcc s = new SolutionAcc();
    boolean output = s.carPooling(trips, capacity);
    boolean passed = output == false;
    System.out.println("testAcc1: " + (passed ? "passed" : "failed"));
  }

  public static void testAcc2() {
    int[][] trips = {{2,1,5},{3,3,7}};
    int capacity = 5;
    SolutionAcc s = new SolutionAcc();
    boolean output = s.carPooling(trips, capacity);
    boolean passed = output == true;
    System.out.println("testAcc2: " + (passed ? "passed" : "failed"));
  }

  public static void testAcc3() {
    int[][] trips = {{5,7,8},{10,2,3},{8,3,9},{3,2,5},{7,4,9},{4,7,8},{3,7,9},{3,3,9}};
    int capacity = 29;
    SolutionAcc s = new SolutionAcc();
    boolean output = s.carPooling(trips, capacity);
    boolean passed = output == false;
    System.out.println("testAcc3: " + (passed ? "passed" : "failed"));
  }

  public static void testAcc4() {
    int[][] trips = {{2,1,5},{3,5,7}};
    int capacity = 3;
    SolutionAcc s = new SolutionAcc();
    boolean output = s.carPooling(trips, capacity);
    boolean passed = output == true;
    System.out.println("testAcc4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    testPQ1();
    testPQ2();
    testPQ3();
    testPQImprv1();
    testPQImprv2();
    testPQImprv3();
    testAcc1();
    testAcc2();
    testAcc3();
    testAcc4();
  }

}
