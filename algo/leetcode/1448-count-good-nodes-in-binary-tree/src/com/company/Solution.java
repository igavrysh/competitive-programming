package com.company;

public class Solution {

  public int goodNodes(TreeNode root) {
    return DFS(root, Integer.MIN_VALUE);
  }

  private int DFS(TreeNode node, int max) {
    if (node == null) {
      return 0;
    }
    int output = 0;
    if (node.val >= max) {
      output = 1;
    }
    int newMax = Math.max(max, node.val);
    output += DFS(node.left, newMax) + DFS(node.right, newMax);
    return output;
  }
}
