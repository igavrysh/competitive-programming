package com.company;

public class Main {

  public static void test1() {
    TreeNode input = new TreeNode(
        3,
        new TreeNode(
            1,
            new TreeNode(3, null, null),
            null
        ),
        new TreeNode(
            4,
            new TreeNode(1, null, null),
            new TreeNode(5, null, null)
        )
    );
    Solution s = new Solution();
    int output = s.goodNodes(input);
    boolean passed = output == 4;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    TreeNode input = new TreeNode(
        3,
        new TreeNode(
            3,
            new TreeNode(4, null, null),
            new TreeNode(2, null, null)
        ),
        null
    );
    Solution s = new Solution();
    int output = s.goodNodes(input);
    boolean passed = output == 3;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    TreeNode input = new TreeNode(1, null, null);
    Solution s = new Solution();
    int output = s.goodNodes(input);
    boolean passed = output == 1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
