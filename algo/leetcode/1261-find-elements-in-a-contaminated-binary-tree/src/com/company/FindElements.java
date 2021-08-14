package com.company;

import java.util.HashSet;
import java.util.Set;

public class FindElements {
  TreeNode T;
  Set<Integer> values;
  int size = 0;

  public FindElements(TreeNode root) {
    this.values = new HashSet<>();
    if (root != null) {
      this.T = new TreeNode(0);
      values.add(0);
      size++;
      createT(root, T);
    }
  }

  private void createT(TreeNode contNode, TreeNode node) {
    if (contNode.left != null) {
      int val = 2 * node.val + 1;
      this.values.add(val);
      node.left = new TreeNode(val);
      size++;
      createT(contNode.left, node.left);
    }
    if (contNode.right != null) {
      int val = 2 * node.val + 2;
      this.values.add(val);
      node.right = new TreeNode(val);
      size++;
      createT(contNode.right, node.right);
    }
  }

  public boolean find(int target) {
    return this.values.contains(target);
  }
}
