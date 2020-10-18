package com.company;

import com.sun.source.tree.Tree;

public class Solution {
  public boolean isSubPath(ListNode head, TreeNode root) {
    // Case 1 Continue
    // Case 2 Start Over
    return DFS(head, head, root);
  }

  private boolean DFS(ListNode currentHead, ListNode globalHead, TreeNode treeNode) {
    if (treeNode == null) {
      return true;
    }

    if (currentHead.val == treeNode.val) {
      return DFS(currentHead.next, globalHead, treeNode.left)
          || DFS(currentHead.next, globalHead, treeNode.right);
    }

    if (globalHead.val == treeNode.val) {
      return DFS(globalHead.next, globalHead, treeNode.left)
          || DFS(globalHead.next, globalHead, treeNode.right);
    }

    if (DFS(currentHead, globalHead, treeNode.left)) {
      return true;
    }

    if (DFS(currentHead, globalHead, treeNode.right)) {
      return true;
    }

    return false;
  }

}
