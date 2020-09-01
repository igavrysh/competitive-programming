package com.company;

public class Solution {

  public int longestConsecutive(TreeNode root) {
    return longestConsecutiveInternal(root, root == null ? 0 : root.val - 1, 0, 0);
  }

  private int longestConsecutiveInternal(TreeNode node, int previousVal, int maxReached, int counter) {
    if (node == null) {
      return maxReached;
    }

    if (previousVal == node.val - 1) {
      counter += 1;
    }

    if (maxReached < counter) {
      maxReached = counter;

    }

    if (previousVal != node.val - 1)  {
      counter = 1;
    }

    return longestConsecutiveInternal(node.right, node.val, maxReached, counter);
  }
}
