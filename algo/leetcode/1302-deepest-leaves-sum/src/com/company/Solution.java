package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int deepestLeavesSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    List<TreeNode> lastLevel = lastLevel(List.of(root));
    int acc = 0;
    for (TreeNode node : lastLevel) {
      acc += node.val;
    }
    return acc;
  }

  public List<TreeNode> lastLevel(List<TreeNode> levels) {
    List<TreeNode> nextLevel = new ArrayList<>();
    for (TreeNode node : levels) {
      if (node.left != null) {
        nextLevel.add(node.left);
      }
      if (node.right != null) {
        nextLevel.add(node.right);
      }
    }
    if (nextLevel.size() == 0) {
      return levels;
    }
    return lastLevel(nextLevel);
  }
}
