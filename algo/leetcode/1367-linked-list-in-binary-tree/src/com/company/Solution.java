package com.company;

public class Solution {

  private ListNode globalHead;

  private int calls = 0;


  public boolean isSubPath(ListNode head, TreeNode root) {
    calls++;
    if (calls %1000 == 0) {
      System.out.println("calls: " + calls);
    }
    this.globalHead = head;
    if (root == null) {
      return false;
    }
    return DFS(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
  }

  private boolean DFS(ListNode currentHead, TreeNode treeNode) {
    calls++;
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

    /*
    if (DFS(globalHead, treeNode.left)) {
      return true;
    }

    if (DFS(globalHead, treeNode.right)) {
      return true;
    }
    */

    return false;
  }

}
