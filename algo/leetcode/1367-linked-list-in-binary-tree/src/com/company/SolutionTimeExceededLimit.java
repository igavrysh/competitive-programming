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

  private boolean DFS(ListNode currentHead, TreeNode treeNode) {
    if (currentHead == null) {
      return true;
    }

    if (treeNode == null) {
      return false;
    }

    if (currentHead.val == treeNode.val) {
      if (DFS(currentHead.next, treeNode.left)) {
        return true;
      }
      if (DFS(currentHead.next, treeNode.right)) {
        return true;
      }
    }

    if (DFS(globalHead, treeNode.left)) {
      return true;
    }

    if (DFS(globalHead, treeNode.right)) {
      return true;
    }

    return false;
  }

}
