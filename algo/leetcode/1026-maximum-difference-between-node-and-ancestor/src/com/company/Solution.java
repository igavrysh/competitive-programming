package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int maxAncestorDiff(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    DFS(root, result);
    return result.get(0);
  }

  private List<Integer> DFS(TreeNode node, List<Integer> result) {
    List<Integer> minmaxL = new ArrayList<>();
    if (node.left != null) {
      minmaxL = DFS(node.left, result);
    }

    List<Integer> minmaxR = new ArrayList<>();
    if (node.right != null) {
      minmaxR = DFS(node.right, result);
    }

    Integer min = minmaxL.size() > 0 ? minmaxL.get(0) : null;
    if (minmaxR.size() > 0) {
      min = min == null ? minmaxR.get(0) : Math.min(min, minmaxR.get(0));
    }

    Integer max = minmaxL.size() > 0 ? minmaxL.get(1) : null;
    if (minmaxR.size() > 0) {
      max = max == null ? minmaxR.get(1) : Math.max(max, minmaxR.get(1));
    }

    Integer currResult = null;
    if (max != null) {
      currResult = max - node.val;
    }
    if (min != null) {
      currResult = Math.max(currResult, node.val - min);
    }
    if (currResult != null) {
      if (result.size() > 0) {
        result.set(0, Math.max(result.get(0), currResult));
      } else {
        result.add(currResult);
      }
    }

    List<Integer> output = new ArrayList<>();
    min = min == null ? node.val : Math.min(node.val, min);
    max = max == null ? node.val : Math.max(node.val, max);
    output.add(min);
    output.add(max);
    return output;
  }
}
