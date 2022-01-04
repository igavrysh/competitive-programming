package com.company;
import java.util.ArrayList;
import java.util.List;

public class Solution {
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    DFS(root1, l1);
    DFS(root2, l2);
    if (l1.size() != l2.size()) {
      return false;
    }
    for (int i = 0; i < l1.size(); i++) {
      if (l1.get(i) != l2.get(i)) {
        return false;
      }
    }
    return true;
  }

  private void DFS(TreeNode node, List<Integer> leaves) {
    if (node.left == null && node.right == null) {
      leaves.add(node.val);
      return;
    }

    if (node.left != null) {
      DFS(node.left, leaves);
    }

    if (node.right != null) {
      DFS(node.right, leaves);
    }
  }
}
