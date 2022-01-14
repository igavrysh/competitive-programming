package com.company;

public class Solution {

  public TreeNode insertIntoBST(TreeNode root, int val) {
    return dfs(root, val);
  }

  public TreeNode dfs(TreeNode node, int val) {
    if (node == null) {
      return new TreeNode(val);
    }
    if (node.left == null && val < node.val) {
      node.left = new TreeNode(val);
      return node;
    } else if (node.right == null && val > node.val) {
      node.right = new TreeNode(val);
      return node;
    }

    if (val < node.val) {
      dfs(node.left, val);
      return node;
    }

    if (val > node.val) {
      dfs(node.right, val);
      return node;
    }

    return null;
  }
}
