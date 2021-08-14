package com.company;

public class Main {

  public static void test1() {
    TreeNode input = new TreeNode(
        1,
        new TreeNode(2,
            new TreeNode(2, null, null),
            null),
        new TreeNode(3,
            new TreeNode(2, null, null),
            new TreeNode(4, null, null)));
    Solution s = new Solution();
    TreeNode output = s.removeLeafNodes(input, 2);
    boolean passed = output != null && output.val == 1
        && output.left == null
        && output.right != null && output.right.val == 3
        && output.right.left == null
        && output.right.right != null && output.right.right.val == 4
        && output.right.right.left == null
        && output.right.right.right == null;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    TreeNode input = new TreeNode(
        1,
        new TreeNode(
            2,
            new TreeNode(
                2,
                new TreeNode(
                    2,
                    null,
                    null),
                null
            ),
            null),
        null);
    Solution s = new Solution();
    TreeNode output = s.removeLeafNodes(input, 2);
    boolean passed = output != null && output.val == 1
        && output.left == null
        && output.right == null;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test3();
  }
}
