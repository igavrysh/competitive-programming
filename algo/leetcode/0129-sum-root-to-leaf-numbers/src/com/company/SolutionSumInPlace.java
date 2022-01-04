package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionSumInPlace {

  public int sumNumbers(TreeNode root) {
    return getNumbers(root, 0);
  }

  private int getNumbers(TreeNode node, int result) {
    if (node == null) {
      return result;
    }
    int lhs = 0;
    int rhs = 0;
    int cumulativeVal = result * 10 + node.val;
    if (node.left != null) {
      lhs = getNumbers(node.left, cumulativeVal);
    }
    if (node.right != null) {
      rhs = getNumbers(node.right, cumulativeVal);
    }
    if (node.left == null && node.right == null) {
      return cumulativeVal;
    }
    return rhs + lhs;
  }
}
