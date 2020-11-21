package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {

    Queue<TreeNode> level = new LinkedList<>();
    if (root != null) {
      level.offer(root);
    }

    List<List<Integer>> output = new ArrayList<>();

    while (level.size() != 0) {
      Stack<TreeNode> nextLevel = new Stack<>();
      int sizeToGet = level.size();
      List<Integer> levelOutput = new ArrayList<>();

      while (sizeToGet != 0) {
        TreeNode current = level.poll();
        levelOutput.add(current.val);

        if (current.left != null) {
          level.offer(current.left);
        }

        if (current.right != null) {
          level.offer(current.right);
        }

        sizeToGet--;
      }
      output.add(0, levelOutput);
    }
    return output;
  }
}
