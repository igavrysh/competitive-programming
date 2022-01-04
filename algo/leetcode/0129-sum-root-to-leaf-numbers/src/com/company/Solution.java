package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int sumNumbers(TreeNode root) {
    List<List<Integer>> output = new ArrayList<>();
    getNumbers(root, new ArrayList<>(), output);
    int result = 0;
    for (List<Integer> l : output) {
      int N = l.size();
      int element = 0;
      int i = 0;
      for (Integer el : l) {
        element += el * Math.pow(10, N - i - 1);
        i++;
      }
      result += element;
    }
    return result;
  }

  private void getNumbers(TreeNode node, List<Integer> digits, List<List<Integer>> output) {
    if (node == null) {
      return;
    }
    digits.add(node.val);
    List<Integer> lhs = new ArrayList<>(digits);
    List<Integer> rhs = new ArrayList<>(digits);
    if (node.left != null) {
      getNumbers(node.left, lhs, output);
    }
    if (node.right != null) {
      getNumbers(node.right, rhs, output);
    }
    if (node.left == null && node.right == null) {
      output.add(digits);
    }
  }
}
