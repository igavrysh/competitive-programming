package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class WordDictionary {
  class Node {
    Node[] children = new Node[26];
    boolean isEOW = false;
  }

  Node root = new Node();

  public WordDictionary() {
  }

  private int idxForC(char c) {
    return c - 'a';
  }

  public void addWord(String word) {
    Node n = root;
    for (int i = 0; i < word.length(); i++) {
      if (n.children[idxForC(word.charAt(i))] == null) {
        n.children[idxForC(word.charAt(i))] = new Node();
      }
      n = n.children[idxForC(word.charAt(i))];
    }
    n.isEOW = true;
  }

  public boolean search(String word) {
    Queue<Node> Q = new LinkedList<>();
    Q.offer(root);
    for (int i = 0; i < word.length(); i++) {
      int j = Q.size();
      while (j > 0) {
        Node node = Q.poll();
        if (word.charAt(i) == '.') {
          for (Node child : node.children) {
            if (child != null) {
              if (i == word.length()-1 && child.isEOW == true) {
                return true;
              }
              Q.offer(child);
            }
          }
        } else if (node.children[idxForC(word.charAt(i))] != null)  {
          if (i == word.length()-1 && node.children[idxForC(word.charAt(i))].isEOW == true) {
            return true;
          } else {
            Q.offer(node.children[idxForC(word.charAt(i))]);
          }
        }
        j--;
      }
    }
    return false;
  }
}
