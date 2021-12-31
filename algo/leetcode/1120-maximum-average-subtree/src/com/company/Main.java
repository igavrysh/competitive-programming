package com.company;

public class Main {

  public static void test1() {
    TreeNode n = new TreeNode(5, new TreeNode(6), new TreeNode(1));
    Solution s = new Solution();
    double output = s.maximumAverageSubtree(n);
    boolean passed = Math.abs(output - 6.0) < Math.pow(10.0, -6);
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    TreeNode n = new TreeNode(0, null, new TreeNode(1));
    Solution s = new Solution();
    double output = s.maximumAverageSubtree(n);
    boolean passed = Math.abs(output - 1.0) < Math.pow(10.0, -6);
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    TreeNode n = new TreeNode(4, new TreeNode(3, new TreeNode(2), null), new TreeNode(1));
    Solution s = new Solution();
    double output = s.maximumAverageSubtree(n);
    boolean passed = Math.abs(output - 2.5) < Math.pow(10.0, -6);
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    TreeNode n = new TreeNode(3, new TreeNode(7, new TreeNode(5), new TreeNode(7)), new TreeNode(2, new TreeNode(7), null));
    Solution s = new Solution();
    double output = s.maximumAverageSubtree(n);
    boolean passed = Math.abs(output - 7.0) < Math.pow(10.0, -6);
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
