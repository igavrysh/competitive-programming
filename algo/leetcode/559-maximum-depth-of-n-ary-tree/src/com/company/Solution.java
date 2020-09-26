package com.company;

public class Solution {

  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    int localMax = 0;
    if (root.children != null) {
      for (Node node : root.children) {
        int current = maxDepth(node);
        if (localMax < current) {
          localMax = current;
        }
      }
    }
    return localMax + 1;
  }

}
