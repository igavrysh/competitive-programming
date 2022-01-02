package com.company;

public class Main {

  public static void test1() {
    TreeNode input = new TreeNode(
        1,
        new TreeNode(2, new TreeNode(4), new TreeNode(5)),
        new TreeNode(3, new TreeNode(6), null)
    );
    Solution s = new Solution();
    int output = s.maxProduct(input);
    boolean passed = output == 110;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    TreeNode input = new TreeNode(
        1,
        null,
        new TreeNode(
            2,
            new TreeNode(3),
            new TreeNode(
                4,
                new TreeNode(5),
                new TreeNode(6)
            )
        )
    );
    Solution s = new Solution();
    int output = s.maxProduct(input);
    boolean passed = output == 90;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    TreeNode input = new TreeNode(
        8,
        new TreeNode(5),
        null
    );
    Solution s = new Solution();
    int output = s.maxProduct(input);
    boolean passed = output == 40;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
