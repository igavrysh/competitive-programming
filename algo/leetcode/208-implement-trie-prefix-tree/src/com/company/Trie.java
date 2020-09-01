package com.company;

public class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!node.containsKey(ch)) {
        node.put(ch, new TrieNode());
      }
      node = node.get(ch);
    }
    node.setEnd();
  }

  private TrieNode searchPrefix(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (node.containsKey(ch)) {
        node = node.get(ch);
      } else {
        return null;
      }
    }
    return node;
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    return searchPrefix(prefix) != null;
  }

}
