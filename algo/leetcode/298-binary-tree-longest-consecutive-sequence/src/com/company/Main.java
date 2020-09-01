package com.company;

public class Main {

  /*
  Input:

    1
     \
      3
     / \
    2   4
         \
          5

  Output: 3
   */
  private static void test1() {
    TreeNode root = new TreeNode(
        1,
        null,
        new TreeNode(
            3,
            new TreeNode(2),
            new TreeNode(
                4,
                null,
                new TreeNode(5)
            )
        )
    );
    SolutionByKevin solution = new SolutionByKevin();
    int output = solution.longestConsecutive(root);
    System.out.println("test1:" + (output == 3 ? "passed" : "failed"));
  }

  /*
  Input:

      3
     / \
    2   4
         \
          5

  Output: 3
   */
  private static void test2() {
    TreeNode root = new TreeNode(
        3,
        new TreeNode(2),
        new TreeNode(
            4,
            null,
            new TreeNode(5)
        )

    );
    SolutionByKevin solution = new SolutionByKevin();
    int output = solution.longestConsecutive(root);
    System.out.println("test2:" + (output == 3 ? "passed" : "failed"));
  }

  /*
  Input:

      2
       \
        3
       /
      2
     /
    1

  Output: 2
  */
  private static void test3() {
    TreeNode root = new TreeNode(
        2,
        null,
        new TreeNode(3, new TreeNode(
            2,
            new TreeNode(1),
            null),
            null));
    SolutionByKevin solution = new SolutionByKevin();
    int output = solution.longestConsecutive(root);
    System.out.println("test3:" + (output == 2 ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
