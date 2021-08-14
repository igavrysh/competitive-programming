package com.company;

public class Solution {
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root.left == null && root.right == null && root.val == target) {
      return null;
    } else if (root.left == null && root.right == null) {
      return root;
    }

    if (root.left != null) {
      root.left = removeLeafNodes(root.left, target);
    }

    if (root.right != null) {
      root.right = removeLeafNodes(root.right, target);
    }

    if (root.left == null && root.right == null && root.val == target) {
      return null;
    }
    return root;
  }
}
