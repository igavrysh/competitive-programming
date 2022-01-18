package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {
  // Encodes a tree to a single string.
  public String serialize(Node root) {
    List<Integer> result = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    if (root != null) {
      result.add(root.val);
    }
    result.add(null);
    while (!queue.isEmpty()) {
      Node n = queue.poll();
      if (n.children != null) {
        for (int i = 0; i < n.children.size(); i++) {
          Node child = n.children.get(i);
          result.add(child.val);
          queue.add(child);
        }
      }
      result.add(null);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i<result.size(); i++) {
      sb.append(result.get(i)==null ? "null" : Integer.toString(result.get(i)));
      if (i<result.size()-1) {
        sb.append(",");
      }
    }
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    return null;
  }
}
