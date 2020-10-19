package com.company;

public class SolutionByOrkhan {
  public boolean isSubPath(ListNode head, TreeNode root) {

    if (root == null) {
      return false;
    }
    if (head == null) {
      return false;
    }
    return dfs(head, root) || isSubPath(head, root.right) || isSubPath(head, root.left);
  }

  private boolean dfs(ListNode head, TreeNode root) {
    if (head == null) {
      return true;
    }

    if (root == null || head.val != root.val) {
      return false;
    }

    return dfs(head.next, root.left) || dfs(head.next, root.right);
  }

}
