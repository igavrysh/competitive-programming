package com.company;

public class Main {

  public static void test1() {
    String instructions = "GGLLGG";
    Solution s = new Solution();
    boolean output = s.isRobotBounded(instructions);
    boolean passed = output == true;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String instructions = "GL";
    Solution s = new Solution();
    boolean output = s.isRobotBounded(instructions);
    boolean passed = output == true;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
