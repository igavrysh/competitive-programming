package com.company;

import java.util.ArrayList;
import java.util.List;

class TrieOwnSolution {

  class Node {
    Character value;
    List<Node> children;

    public Node(Character value) {
      this.value = value;
      children = new ArrayList<>();
    }

    public Node(Character value, List<Node> children) {
      this.value = value;
      this.children = children;
    }
  }

  List<Node> root;

  /**
   * Initialize your data structure here.
   */
  public TrieOwnSolution() {
    root = new ArrayList<>();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    insertIntoList(word, root, 0);
  }

  private void insertIntoList(String word, List<Node> children, int index) {
    if (index >= word.length()) {
      for (Node n : children) {
        if (n.value == null) {
          return;
        }
      }
      children.add(new Node(null));
      return;
    }

    for (Node node : children) {
      if (node.value != null && word.length() > index && node.value == word.charAt(index)) {
        insertIntoList(word, node.children, index + 1);
        return;
      }
    }

    Node node = new Node(word.charAt(index));
    children.add(node);
    insertIntoList(word, node.children, index + 1);
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    return searchInternal(word, root, 0, -1);
  }

  private boolean searchInternal(
      String word,
      List<Node> children,
      int index,
      int maxCheck
  ) {
    if (maxCheck == -1) {
      if (index >= word.length()) {
        for (Node n : children) {
          if (n.value == null) {
            return true;
          }
        }
        return false;
      }
    } else {
      if (index >= maxCheck) {
        return true;
      }
    }

    if (index < word.length() && children == null) {
      return false;
    }

    for (Node node : children) {
      if (node.value == null) {
        continue;
      }

      if (node.value == word.charAt(index)) {
        return searchInternal(
            word,
            node.children,
            index + 1,
            maxCheck);
      }
    }

    return false;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    return searchInternal(prefix, root, 0, prefix.length());
  }
}