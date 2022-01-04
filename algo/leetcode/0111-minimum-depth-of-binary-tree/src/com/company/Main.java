package com.company;

public class Main {

  public static void test1() {
    TreeNode root = new TreeNode(
        3,
        new TreeNode(
            9
        ),
        new TreeNode(
            20,
            new TreeNode(
                15
            ),
            new TreeNode(
                7
            )
        )
    );
    Solution s = new Solution();
    int output = s.minDepth(root);
    boolean passed = output == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    TreeNode root = new TreeNode(
        2,
        null,
        new TreeNode(
            3,
            null,
            new TreeNode(
                4,
                null,
                new TreeNode(
                    5,
                    null,
                    new TreeNode(6)
                )
            )
        )
    );
    Solution s = new Solution();
    int output = s.minDepth(root);
    boolean passed = output == 5;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    //test1();
    test2();
  }
}
