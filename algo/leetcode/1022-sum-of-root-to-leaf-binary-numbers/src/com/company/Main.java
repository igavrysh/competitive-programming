package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    TreeNode input = new TreeNode(
        1,
        new TreeNode(
            0,
            new TreeNode(0),
            new TreeNode(1)),
        new TreeNode(
            1,
            new TreeNode(0),
            new TreeNode(1)));
    int output = s.sumRootToLeaf(input);
    boolean passed = output == 22;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    TreeNode input = new TreeNode(0);
    int output = s.sumRootToLeaf(input);
    boolean passed = output == 0;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
