package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    calc(root, new ArrayList<>(), targetSum, result);
    return result;
  }

  private void calc(TreeNode node, List<Integer> path, int remainingSum,
      List<List<Integer>> result) {
    if (node == null) {
      return;
    }

    if (node.right == null && node.left == null) {
      if (remainingSum == node.val) {
        path.add(node.val);
        result.add(new ArrayList<>(path));
        path.remove(path.size()-1);
      }
      return;
    }
    path.add(node.val);
    calc(node.left, path, remainingSum - node.val, result);
    calc(node.right, path, remainingSum - node.val, result);
    path.remove(path.size()-1);
  }
}
