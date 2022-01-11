package com.company;

public class Solution {

  public int sumRootToLeaf(TreeNode root) {
    return dfs(root, 0);
  }

  private int dfs(TreeNode node, int acc) {
    acc = acc * 2 + node.val;
    if (node.left == null && node.right == null) {
      return acc;
    }
    int lVal = 0, rVal = 0;
    if (node.left != null) {
      lVal = dfs(node.left, acc);
    }
    if (node.right != null) {
      rVal = dfs(node.right, acc);
    }
    return lVal + rVal;
  }

}
