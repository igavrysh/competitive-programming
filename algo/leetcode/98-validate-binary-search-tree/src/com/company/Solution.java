package com.company;

class Solution {
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValidBST(TreeNode root, Long min, Long max) {
    if (root == null) {
      return true;
    }

    if (root.val <= min || root.val >= max) {
      return false;
    }

    boolean leftChecked = false;
    if (root.left != null) {
      if (!isValidBST(root.left, min, (long)root.val)) {
        return false;
      }
    }

    if (root.right != null) {
      if (!isValidBST(root.right, (long)root.val, max)) {
        return false;
      }
    }
    return true;
  }
}


/* Incorrect solution
that ignores Example 3 case:
*/
/*
class Solution {
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (root.left != null && root.val <= root.left.val) {
      return false;
    }

    if (root.right != null && root.val >= root.right.val) {
      return false;
    }

    boolean leftSideCheck = isValidBST(root.left);
    if (!leftSideCheck) {
      return false;
    }

    boolean  rightSideCheck = isValidBST(root.right);
    if (!rightSideCheck) {
      return false;
    }
    return true;
  }
}


 */