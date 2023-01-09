package com.company;

class Solution {
  TreeNode m1 = null;
  TreeNode m2 = null;
  boolean foundM1 = false;
  boolean foundM2 = false;

  public void recoverTree(TreeNode root) {
    inorderForward(root); // forward
    inorderBackward(root); // backward

    int temp = m1.val;
    m1.val = m2.val;
    m2.val = temp;
  }

  public void inorderForward(TreeNode root) {
    if (root == null) {
      return;
    }

    inorderForward(root.left);

    if (m1 != null && m1.val > root.val) {
      foundM1 = true;
      return;
    }
    if (!foundM1) {
      m1 = root;
    }
    inorderForward(root.right);
  }

  public void inorderBackward(TreeNode root) {
    if (root == null) {
      return;
    }

    inorderBackward(root.right);
    if (m2 != null && m2.val < root.val) {
      foundM2 = true;
      return;
    }

    if (!foundM2)
      m2 = root;
    inorderBackward(root.left);
  }
}
