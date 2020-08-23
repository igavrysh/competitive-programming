package com.company;

public class Main {

  private static void test1() {
    TreeNode input = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    Solution solution = new Solution();
    int output = solution.sumNumbers(input);
    boolean passed = output == 25;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    TreeNode input = new TreeNode(1);
    Solution solution = new Solution();
    int output = solution.sumNumbers(input);
    boolean passed = output == 1;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    Solution solution = new Solution();
    int output = solution.sumNumbers(null);
    boolean passed = output == 0;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
