package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> lhs = new ArrayList<>();
    if (root == null) {
      return lhs;
    }

    if (root.left != null) {
      lhs = inorderTraversal(root.left);
    }

    List<Integer> rhs = new ArrayList<>();
    if (root.right != null) {
      rhs = inorderTraversal(root.right);
    }

    lhs.add(root.val);
    lhs.addAll(rhs);
    return lhs;
  }
}
