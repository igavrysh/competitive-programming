package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionResultPassedAsArgument {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorderTraversal(root, result);
    return result;
  }

  public void inorderTraversal(TreeNode root, List<Integer> result) {
    if (root != null) {
      if (root.left != null) {
        inorderTraversal(root.left, result);
      }
      result.add(root.val);
      if (root.right != null) {
        inorderTraversal(root.right, result);
      }
    }
  }
}
