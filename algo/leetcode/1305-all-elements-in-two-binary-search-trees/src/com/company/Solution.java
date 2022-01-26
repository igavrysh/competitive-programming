package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
    dfs(root1, l1);
    dfs(root2, l2);

    int indx1 = 0;
    int indx2 = 0;
    List<Integer> result = new ArrayList<>();
    while (indx1 < l1.size() || indx2 < l2.size()) {
      if (indx1 == l1.size() || (indx2 < l2.size() && l1.get(indx1) >= l2.get(indx2))) {
        result.add(l2.get(indx2));
        indx2++;
      } else if (indx2 == l2.size() || (indx1 < l1.size() &&  l1.get(indx1) < l2.get(indx2))) {
        result.add(l1.get(indx1));
        indx1++;
      }
    }
    return result;
  }

  private void dfs(TreeNode node, List<Integer> acc) {
    if (node == null) {
      return;
    }
    dfs(node.left, acc);
    acc.add(node.val);
    dfs(node.right, acc);
  }
}
