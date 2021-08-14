package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public TreeNode balanceBST(TreeNode root) {
    List<Integer> acc = new ArrayList<>();
    if (root != null) {
      inorderTraversal(root, acc);
    }
    return graphFromArray(acc, 0, acc.size()-1);
  }

  private void inorderTraversal(TreeNode node, List<Integer> acc) {
    if (node.left != null) {
      inorderTraversal(node.left, acc);
    }
    acc.add(node.val);
    if (node.right != null) {
      inorderTraversal(node.right, acc);
    }
  }

  private TreeNode graphFromArray(List<Integer> acc, int s, int e) {
    if (e >= acc.size() || s < 0) {
      return null;
    }
    int m = (e + s) / 2;
    if (m >= s && m <= e) {
      TreeNode node = new TreeNode(acc.get(m));
      node.left = graphFromArray(acc, s, m-1);
      node.right = graphFromArray(acc, m+1, e);
      return node;
    }
    return null;
  }
}
