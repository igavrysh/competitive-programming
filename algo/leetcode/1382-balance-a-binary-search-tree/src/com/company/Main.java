package com.company;

public class Main {

  public static void test1() {
    TreeNode input = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, null))));
    Solution s = new Solution();
    TreeNode output = s.balanceBST(input);
    boolean passed =  (
        output != null && output.val == 2
            && output.left != null && output.left.val == 1
            && output.left.left == null
            && output.left.right == null
            && output.right != null && output.right.val == 3
            && output.right.left == null
            && output.right.right != null && output.right.right.val == 4
    ) || (
        output != null && output.val == 3
            && output.left != null && output.left.val == 1
            && output.left.left == null
            && output.left.right != null && output.left.right.val == 2
            && output.right != null && output.right.val == 4
            && output.right.left == null
            && output.right.right == null
        );
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
