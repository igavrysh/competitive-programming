package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutocompleteSystem {
  class Node implements Comparable<Node> {
    Node[] children = new Node[27];
    List<Node> hot = new ArrayList<>();
    int w = 0;
    String s = "";

    @Override
    public int compareTo(Node o) {
      return this.w == o.w ? this.s.compareTo(o.s) : o.w - this.w;
    }

    public void update(Node n) {
      if (!hot.contains(n)) {
        hot.add(n);
      }

      Collections.sort(hot);
      if (hot.size() > 3) {
        hot.remove(hot.size()-1);
      }
    }
  }

  private Node root = new Node();

  private Node currNode = root;
  private String currSentence = "";

  private int idx(char c) {
    return c == ' ' ? 26 : c - 'a';
  }

  public AutocompleteSystem(String[] sentences, int[] times) {
    for (int i = 0; i < sentences.length; i++) {
      add(sentences[i], times[i]);
    }
  }

  private void add(String sentence, int w) {
    if (sentence.length() == 0) {
      return;
    }
    Node n = root;
    List<Node> toUpdate = new ArrayList<>();
    toUpdate.add(root);

    String sent = "";
    for (int i = 0; i < sentence.length(); i++) {
      char c = sentence.charAt(i);
      sent += c;
      int idx = idx(c);
      Node next = n.children[idx];
      if (next == null) {
        next = new Node();
        next.s = sent;
      }
      n.children[idx] = next;
      n = next;
      toUpdate.add(n);
    }

    n.w = n.w + w;

    for (Node node : toUpdate) {
      node.update(n);
    }
  }

  public List<String> input(char c) {
    List<String> output = new ArrayList<>();
    if (c == '#') {
      add(currSentence, 1);
      currNode = root;
      currSentence = "";
      return output;
    }

    currSentence += c;
    if (currNode != null) {
      currNode = currNode.children[idx(c)];
    }

    if (currNode != null) {
      output = currNode.hot.stream().map((Node n) -> n.s).collect(Collectors.toList());
    }

    return output;
  }

}
