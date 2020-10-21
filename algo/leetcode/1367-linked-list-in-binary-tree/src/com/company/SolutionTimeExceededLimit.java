package com.company;

public class SolutionTimeExceededLimit {

  private ListNode globalHead;

  public boolean isSubPath(ListNode head, TreeNode root) {
    this.globalHead = head;
    if (root == null) {
      return false;
    }
    return DFS(head, root);
  }

  private boolean DFS(ListNode currentHead, TreeNode currentRoot) {
    if (currentHead == null) {
      return true;
    }

    if (currentRoot == null) {
      return false;
    }

    if (currentHead.val == currentRoot.val ) {
      if (DFS(currentHead.next, currentRoot.left)) {
        return true;
      }
      if (DFS(currentHead.next, currentRoot.right)) {
        return true;
      }
    }

    return DFS(globalHead, currentRoot.left) || DFS(globalHead, currentRoot.right);
  }


/*
    public boolean isSubPath77(final ListNode head, final TreeNode root) {
      if (root == null) {
        return false;
      }
      if (root.val == head.val) {
        final ListNode currentHead = head.next;
        if (currentHead == null) {
          return true;
        }
        if (root.left != null && root.left.val == currentHead.val) {
          if (isSubPath(currentHead, root.left)) {
            return true;
          }
        }
        if (root.right != null && root.right.val == currentHead.val) {
          return isSubPath(currentHead, root.right);
        }
      }
      return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
*/


}
