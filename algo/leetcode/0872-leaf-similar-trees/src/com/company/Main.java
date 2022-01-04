package com.company;

public class Main {

  public static void test1() {
    TreeNode t1 = new TreeNode(
        3,
        new TreeNode(
            5,
            new TreeNode(6),
            new TreeNode(
                2,
                new TreeNode(7),
                new TreeNode(4)
            )),
        new TreeNode(
            1,
            new TreeNode(9),
            new TreeNode(8)
        )
    );
    TreeNode t2 = new TreeNode(
        2,
        new TreeNode(
            5,
            new TreeNode(6),
            new TreeNode(7)
        ),
        new TreeNode(
            1,
            new TreeNode(4),
            new TreeNode(
                2,
                new TreeNode(9),
                new TreeNode(8)
            )
        )
    );

    Solution s = new Solution();
    boolean output = s.leafSimilar(t1, t2);
    boolean passed = output == true;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
