package com.company;

public class SolutionOptimized {
  public Node connect(Node root) {
    if (root == null) {
      return root;
    }
    root.next = null;
    fillPointers(root);
    return root;
  }

  public void fillPointers(Node n) {
    if (n == null) {
      return;
    }

    if (n.left != null) {
      n.left.next = n.right;
    }

    if (n.right != null) {
      if (n.next != null) {
        n.right.next = n.next.left;
      } else {
        n.right.next = null;
      }
    }
    fillPointers(n.right);
    fillPointers(n.left);
  }
}
