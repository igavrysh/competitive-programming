package com.company;

public class Main {

  public static void test1() {
    TreeNode root = new TreeNode(
        1,
        new TreeNode(
            2,
            new TreeNode(
                4,
                new TreeNode(7),
                null
            ),
            new TreeNode(
                5
            )
        ),
        new TreeNode(
            3,
            null,
            new TreeNode(
                6,
                null,
                new TreeNode(8))
        )
    );
    Solution s = new Solution();
    int output = s.deepestLeavesSum(root);
    boolean passed = output == 15;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
