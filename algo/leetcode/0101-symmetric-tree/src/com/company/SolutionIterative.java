package com.company;

import java.util.*;

public class SolutionIterative {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (q.size() > 0) {
      int size = q.size();
      int levelSize = size;
      int i = 0;
      Stack<Integer> halfEls = new Stack<>();
      while(size-- > 0) {
        TreeNode current = q.poll();
        if (current != null) {
          q.offer(current.left);
          q.offer(current.right);
        }
        if (i < (levelSize/2) ) {
          halfEls.push(current == null ? null : current.val);
        } else {
          if (i >= (levelSize/2) + (levelSize%2)) {
            if (halfEls.pop()
                != (current == null ? null : current.val)
            ) {
              return false;
            }
          }
        }
        i++;
      }
    }
    return true;
  }
}
