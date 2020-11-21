package com.company;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SolutionOptimized {

  public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> level = new LinkedList<>();
    if (root != null) {
      level.offer(root);
    }

    int result = 0;

    while (level.size() != 0) {
      Stack<TreeNode> nextLevel = new Stack<>();
      int sizeToGet = level.size();
      boolean isFirst = true;
      while (sizeToGet != 0) {
        TreeNode current = level.poll();
        if (isFirst) {
          isFirst = false;
          result = current.val;
        }

        if (current.left != null) {
          level.offer(current.left);
        }

        if (current.right != null) {
          level.offer(current.right);
        }
        sizeToGet--;
      }
    }
    return result;
  }
}
