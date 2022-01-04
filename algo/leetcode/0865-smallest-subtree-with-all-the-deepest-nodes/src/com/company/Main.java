package com.company;

public class Main {

  public static void test1() {
    TreeNode input = new TreeNode(
        3,
        new TreeNode(
            5,
            new TreeNode(6, null, null),
            new TreeNode(
                2,
                new TreeNode(7, null, null),
                new TreeNode(4, null, null)
            )),
        new TreeNode(
            1,
            new TreeNode(0, null, null),
            new TreeNode(8, null, null))
    );
    Solution s = new Solution();
    TreeNode output = s.subtreeWithAllDeepest(input);
    boolean passed = output.val == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    TreeNode input = new TreeNode(1, null, null);
    Solution s = new Solution();
    TreeNode output = s.subtreeWithAllDeepest(input);
    boolean passed = output.val == 1;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    TreeNode input = new TreeNode(
        0,
        new TreeNode(1, null, null),
        new TreeNode(
            3,
            null,
            new TreeNode(2, null, null))
    );
    Solution s = new Solution();
    TreeNode output = s.subtreeWithAllDeepest(input);
    boolean passed = output.val == 2;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
