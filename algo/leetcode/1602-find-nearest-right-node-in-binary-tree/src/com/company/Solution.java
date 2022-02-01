package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
    Queue<TreeNode> Q = new LinkedList<>();
    TreeNode prev = null;
    Q.add(root);
    while (!Q.isEmpty()) {
      int level = Q.size();
      while (level > 0) {
        TreeNode tn = Q.poll();
        if (prev == u) {
          return tn;
        }
        if (tn.left != null) {
          Q.offer(tn.left);
        }
        if (tn.right != null) {
          Q.offer(tn.right);
        }
        if (level != 1) {
          prev = tn;
        } else {
          prev = null;
        }
        level--;
      }
    }
    return null;
  }
}
