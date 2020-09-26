package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> output = new ArrayList<>();
    if (root == null) {
      return output;
    }

    levels(List.of(root), output);
    return output;

  }

  private void levels(List<TreeNode> level, List<List<Integer>> output) {
    List<Integer> currLevel = new ArrayList<>();
    List<TreeNode> nextNodes = new ArrayList<>();
    for (TreeNode node : level) {
      currLevel.add(node.val);
      if (node.left != null) {
        nextNodes.add(node.left);
      }

      if (node.right != null) {
        nextNodes.add(node.right);
      }
    }
    output.add(currLevel);
    if (nextNodes.size() > 0) {
      levels(nextNodes, output);
    }
  }

}
