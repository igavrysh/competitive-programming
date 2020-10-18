package com.company;

public class Main {

  public static void test1() {
    TreeNode inputTree = new TreeNode(
        1,
        new TreeNode(
            4,
            null,
            new TreeNode(
                2,
                new TreeNode(1),
                null)),
        new TreeNode(
            4,
            new TreeNode(
                2,
                new TreeNode(6),
                new TreeNode(
                    8,
                    new TreeNode(1),
                    new TreeNode(3))),
            null
        )
    );
    ListNode inputList = new ListNode(4, new ListNode(2, new ListNode(8)));
    Solution s = new Solution();
    boolean output = s.isSubPath(inputList, inputTree);
    boolean passed = output == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));

  }

  public static void main(String[] args) {
    test1();
  }
}
