package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  public Node connect(Node root) {
    if (root == null) {
      return root;
    }

    Queue<Node> l = new LinkedList<>();
    l.add(root);

    while (l.size() > 0) {
      int currL = l.size();
      while (currL > 0) {
        Node node = l.poll();
        currL--;
        if (currL == 0) {
          node.next = null;
        } else {
          node.next = l.peek();
        }
        if (node.left != null) {
          l.offer(node.left);
        }
        if (node.right != null) {
          l.offer(node.right);
        }
      }
    }
    return root;
  }

}
