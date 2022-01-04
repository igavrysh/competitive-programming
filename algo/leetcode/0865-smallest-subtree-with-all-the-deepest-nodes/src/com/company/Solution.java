package com.company;

public class Solution {
  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    if (root == null) {
      return null;
    }
    Pair pair = DFS(0, root);
    return pair.subtree;
  }

  class Pair {
    int maxLevel;
    TreeNode subtree;
    Pair(int maxLevel, TreeNode subtree) {
      this.maxLevel = maxLevel;
      this.subtree = subtree;
    }
  }

  private Pair DFS(int level, TreeNode node) {
    if (node.left == null && node.right == null) {
      return new Pair(level, node);
    }
    Pair lPair = node.left != null ? DFS(level+1, node.left) : null;
    Pair rPair = node.right != null ? DFS(level+1, node.right) : null;
    if (lPair == null && rPair != null) {
      return rPair;
    }
    if (lPair != null && rPair == null) {
      return lPair;
    }
    if (lPair.maxLevel > rPair.maxLevel) {
      return lPair;
    }
    if (lPair.maxLevel < rPair.maxLevel) {
      return rPair;
    }
    return new Pair(lPair.maxLevel, node);
  }
}
