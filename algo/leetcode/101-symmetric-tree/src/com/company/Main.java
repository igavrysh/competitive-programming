package com.company;

public class Main {

  private static void test1() {
    TreeNode input = new TreeNode(
        1,
        new TreeNode(
            2,
            new TreeNode(3),
            new TreeNode(4)
        ),
        new TreeNode(
            2,
            new TreeNode(4),
            new TreeNode(3)
        )
    );
    SolutionIterative s = new SolutionIterative();
    boolean output = s.isSymmetric(input);
    boolean passed = output == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }
  /*
      1
   / \
  2   2
   \   \
   3    3
   */
  private static void test2() {
    TreeNode input = new TreeNode(
        1,
        new TreeNode(
            2,
            null,
            new TreeNode(3)
        ),
        new TreeNode(
            2,
            null,
            new TreeNode(3)
        )
    );
    SolutionIterative s = new SolutionIterative();
    boolean output = s.isSymmetric(input);
    boolean passed = output == false;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    //test1();
    test2();
  }
}
