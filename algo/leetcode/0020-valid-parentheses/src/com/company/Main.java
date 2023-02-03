package com.company;

public class Main {

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
  }
  
  public static void test1() {
    SolutionPractice solution = new SolutionPractice();
    boolean passed = solution.isValid("()") == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    SolutionPractice solution = new SolutionPractice();
    boolean passed = solution.isValid("()[]{}") == true;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    SolutionPractice solution = new SolutionPractice();
    boolean passed = solution.isValid("(]") == false;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }
  public static void test4() {
    SolutionPractice solution = new SolutionPractice();
    boolean passed = solution.isValid("([)]") == false;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    SolutionPractice solution = new SolutionPractice();
    boolean passed = solution.isValid("{[]}") == true;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    SolutionPractice solution = new SolutionPractice();
    boolean passed = solution.isValid("[[]]") == true;
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    SolutionPractice solution = new SolutionPractice();
    boolean passed = solution.isValid("]") == false;
    System.out.println("test7:" + (passed ? "passed" : "failed"));
  }


}
