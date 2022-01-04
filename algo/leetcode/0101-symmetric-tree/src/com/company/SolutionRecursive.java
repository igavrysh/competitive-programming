package com.company;

public class SolutionRecursive {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode l, TreeNode r) {
    if (r == null && l == null) {
      return true;
    }

    if ((r == null && l != null)
        || (r != null) && (l == null)
    ) {
      return false;
    }

    if (l.val == r.val) {
      if (isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left)) {
        return true;
      }
    }
    return false;
  }
}
