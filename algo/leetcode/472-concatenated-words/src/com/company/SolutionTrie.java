package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTrie {

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Arrays.sort(words, (String w1, String w2) -> { return w1.length() - w2.length(); });
    List<String> output = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      if (words.length == 0) {
        continue;
      }
      if (dfs(0, rootNode, words[i])) {
        output.add(words[i]);
      } else {
        addToTree(words[i], rootNode);
      }
    }
    return output;
  }

  private boolean dfs(int i, Node curr, String word) {
    if (i == word.length()) {
      return curr.isWord;
    }
    char c = word.charAt(i);
    Node n = curr.nodes[c-'a'];
    if (n == null) {
      return false;
    }

    if (n.isWord && dfs(i+1, rootNode, word)) {
      return true;
    }
    return dfs(i+1, n, word);
  }

  class Node {
    Node[] nodes = new Node[26];
    boolean isWord = false;
  }

  Node rootNode = new Node();

  private void addToTree(String word, Node curr) {
    if (word.length() == 0) {
      return;
    }
    for (char c : word.toCharArray()) {
      if (curr.nodes[c-'a'] == null) {
        curr.nodes[c-'a'] = new Node();
      }
      curr = curr.nodes[c-'a'];
    }
    curr.isWord = true;
  }

}
