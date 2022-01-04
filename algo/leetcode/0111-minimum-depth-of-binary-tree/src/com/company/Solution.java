package com.company;

public class Solution {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 1;
    }

    int leftMin = Integer.MAX_VALUE-1;
    int rightMin = Integer.MAX_VALUE-1;
    if (root.left != null) {
      leftMin = minDepth(root.left);
    }
    if (root.right != null) {
      rightMin = minDepth(root.right);
    }

    return Math.min(1 + leftMin, 1 + rightMin);
  }
}
