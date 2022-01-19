package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {
  private String NULL_STRING = "null";

  // Encodes a tree to a single string.
  public String serialize(Node root) {
    List<Integer> result = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    if (root != null) {
      queue.add(root);
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
      sb.append(result.get(i)==null ? NULL_STRING : Integer.toString(result.get(i)));
      if (i<result.size()-1) {
        sb.append(",");
      }
    }
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    String[] words = data.split(",");
    if (words.length == 0 || words[0].contentEquals(NULL_STRING)) {
      return null;
    }
    Queue<Node> Q = new LinkedList<>();
    Node root = new Node(Integer.parseInt(words[0]));
    Q.add(root);
    int i = 2;
    while (!Q.isEmpty()) {
      Node node = Q.poll();
      List<Node> children = new ArrayList<>();
      while (i < words.length && !words[i].equals(NULL_STRING)) {
        Node newNode = new Node(Integer.parseInt(words[i]));
        children.add(newNode);
        Q.add(newNode);
        i++;
      }
      node.children = children;
      if (i < words.length && words[i].equals(NULL_STRING)) {
        i++;
      }
    }
    return root;
  }
}

