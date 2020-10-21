package com.company;

public class SolutionOptimized {
  class Solution {
    public boolean isSubPath(final ListNode head, final TreeNode root) {
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
  }

}
