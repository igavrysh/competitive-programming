package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public List<Integer> largestValues(TreeNode root) {
    Queue<TreeNode> Q = new LinkedList<>();
    List<Integer> output = new ArrayList<>();
    if (root != null) {
      Q.add(root);
    }
    while (!Q.isEmpty()) {
      int size = Q.size();
      int i = 0;
      int max = Integer.MIN_VALUE;
      while (i < size) {
        TreeNode n = Q.poll(); {
          if (i == 0) {
            max = n.val;
          } else {
            max = Math.max(max, n.val);
          }
        }
        i++;
        if (n.left != null) {
          Q.offer(n.left);
        }
        if (n.right != null) {
          Q.offer(n.right);
        }
      }
      output.add(max);
    }
    return output;
  }
}
