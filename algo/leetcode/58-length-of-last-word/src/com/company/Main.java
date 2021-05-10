package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    String input = "Hello World";
    int output = s.lengthOfLastWord(input);
    boolean passed = output == 5;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    String input = " ";
    int output = s.lengthOfLastWord(input);
    boolean passed = output == 0;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    String input = "";
    int output = s.lengthOfLastWord(input);
    boolean passed = output == 0;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    String input = "a";
    int output = s.lengthOfLastWord(input);
    boolean passed = output == 1;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    Solution s = new Solution();
    String input = "a ";
    int output = s.lengthOfLastWord(input);
    boolean passed = output == 1;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    Solution s = new Solution();
    String input = "b   a    ";
    int output = s.lengthOfLastWord(input);
    boolean passed = output == 1;
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
  }
}
