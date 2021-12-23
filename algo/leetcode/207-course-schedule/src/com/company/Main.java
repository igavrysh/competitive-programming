package com.company;

public class Main {

  public static void test1() {
    int numCourses = 2;
    int[][] prereq = {{1,0}};
    Solution s = new Solution();
    boolean output = s.canFinish(numCourses, prereq);
    boolean passed = output == true;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int numCourses = 2;
    int[][] prereq = {{1,0}, {0, 1}};
    Solution s = new Solution();
    boolean output = s.canFinish(numCourses, prereq);
    boolean passed = output == false;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void testIndegree1() {
    int numCourses = 2;
    int[][] prereq = {{1,0}};
    SolutionIndegree s = new SolutionIndegree();
    boolean output = s.canFinish(numCourses, prereq);
    boolean passed = output == true;
    System.out.println("testIndegree1: " + (passed ? "passed" : "failed"));
  }

  public static void testIndegree2() {
    int numCourses = 2;
    int[][] prereq = {{1,0}, {0, 1}};
    SolutionIndegree s = new SolutionIndegree();
    boolean output = s.canFinish(numCourses, prereq);
    boolean passed = output == false;
    System.out.println("testIndegree2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();

    testIndegree1();
    testIndegree2();
  }
}
