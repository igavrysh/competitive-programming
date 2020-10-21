package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BSTGenerator {
  static TreeNode arrayToBST(Integer[] array) {
    if (array.length == 0) {
      return null;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode output = new TreeNode(array[0]);
    queue.offer(output);
    int idx = 1;
    while (queue.size() > 0 && idx < array.length) {
      TreeNode root = queue.poll();
      TreeNode left = null, right = null;
      if (array[idx] != null) {
        left = new TreeNode(array[idx]);
        queue.offer(left);
      }
      idx++;
      if (array[idx] != null) {
        right = new TreeNode(array[idx]);
        queue.offer(right);
      }
      idx++;
      root.left = left;
      root.right = right;
    }
    return output;
  }
}
