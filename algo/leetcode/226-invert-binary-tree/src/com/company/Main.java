package com.company;

public class Main {

  public static void test1() {
    TreeNode tree = new TreeNode(
        4,
        new TreeNode(2,
            new TreeNode(1),
            new TreeNode(3)),
        new TreeNode(7,
            new TreeNode(6),
            new TreeNode(9))
    );

    SolutionInPlace solution = new SolutionInPlace();
    TreeNode output = solution.invertTree(tree);

    boolean passed = output.val == 4
        && output.left.val == 7
        && output.right.val == 2
        && output.left.left.val == 9
        && output.left.right.val == 6
        && output.right.left.val == 3
        && output.right.right.val == 1;

    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void testEmpty() {
    TreeNode tree = new TreeNode();
    SolutionInPlace solution = new SolutionInPlace();
    TreeNode output = solution.invertTree(tree);

    boolean passed = output.left == null
      && output.right == null;
    System.out.println("testEmpty:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    testEmpty();

  }
}
