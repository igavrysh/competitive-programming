package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionMorrisTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    TreeNode current = root;

    TreeNode resultRootNode = root;

    while (current != null) {
      if (current.left != null) {
        TreeNode rightestInLestSubtree = current.left;
        while (rightestInLestSubtree.right != null) {
          rightestInLestSubtree = rightestInLestSubtree.right;
        }

        rightestInLestSubtree.right = current;

        if (resultRootNode == current) {
          resultRootNode = current.left;
        }
        TreeNode temp = current;
        current = current.left;
        temp.left = null;
      } else {
        current = current.right;
      }
    }

    ArrayList<Integer> result = new ArrayList<>();
    TreeNode pointer = resultRootNode;
    while(pointer != null) {
      result.add(pointer.val);
      pointer = pointer.right;
    }

    return result;
  }
}
