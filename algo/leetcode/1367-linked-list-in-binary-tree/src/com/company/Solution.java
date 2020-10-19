package com.company;

public class Solution {
  public boolean isSubPath(ListNode head, TreeNode root) {
    return DFS(head, head, root);
  }

  private boolean DFS(ListNode currentHead, ListNode globalHead, TreeNode treeNode) {
    if (currentHead == null) {
      return true;
    }

    if (treeNode == null) {
      return false;
    }

    if (currentHead.val == treeNode.val) {
      if (DFS(currentHead.next, globalHead, treeNode.left)) {
        return true;
      }
      if (DFS(currentHead.next, globalHead, treeNode.right)) {
        return true;
      }
    }

    if (DFS(globalHead, globalHead, treeNode.left)) {
      return true;
    }

    if (DFS(globalHead, globalHead, treeNode.right)) {
      return true;
    }

    return false;
  }

}
