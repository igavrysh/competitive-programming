package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionMorrisTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    TreeNode current = root;

    TreeNode resultRootNode = root;
    TreeNode previousNode = null;

    List<Integer> result = new ArrayList<>();

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
        if (previousNode != null) {
          previousNode.right = current;
        }
        temp.left = null;
      } else {
        previousNode = current;
        result.add(current.val);
        current = current.right;
      }
    }

    /*
    ArrayList<Integer> result = new ArrayList<>();
    TreeNode pointer = resultRootNode;
    while(pointer != null) {
      result.add(pointer.val);
      pointer = pointer.right;
    }

     */

    return result;
  }
}
