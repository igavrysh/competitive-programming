package com.company;

public class SolutionInPlace {

  public TreeNode invertTree(TreeNode root) {
    invertInternal(root);
    return root;
  }

  private void invertInternal(TreeNode node) {
    if (node == null) {
      return;
    }

    invertTree(node.left);

    invertTree(node.right);

    TreeNode tmp = node.left;
    node.left = node.right;
    node.right = tmp;
  }
}
