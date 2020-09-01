package com.company;

public class Main {

  public static void test1() {
    Solution solution = new Solution();
    String output = solution.reorganizeString("aab");
    boolean passed = output.equals("aba");
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution solution = new Solution();
    String output = solution.reorganizeString("aaab");
    boolean passed = output.equals("");
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution solution = new Solution();
    String output = solution.reorganizeString("vvvlo");
    boolean passed = output.equals("vlvov");
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    SolutionByKevin solution = new SolutionByKevin();
    String output = solution.reorganizeString("aabb");
    boolean passed = output.equals("abab") || output.equals("baba");
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    SolutionByKevin solution = new SolutionByKevin();
    String output = solution.reorganizeString("bbaa");
    boolean passed = output.equals("abab") || output.equals("baba");
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    SolutionByKevin solution = new SolutionByKevin();
    String output = solution.reorganizeString("abab");
    boolean passed = output.equals("abab") || output.equals("baba");
    System.out.println("test6:" + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    SolutionByKevin solution = new SolutionByKevin();
    String output = solution.reorganizeString("baba");
    boolean passed = output.equals("abab") || output.equals("baba");
    System.out.println("test7:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
  }
}
