package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
  public List<String> findWords(char[][] board, String[] words) {
    Trie trie = new Trie();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        buildTrie(trie, "", new HashSet<>(), i, j, board);
      }
    }

    List<String> output = new ArrayList<>();

    for (String word : words) {
      if (trie.searchPrefix(word) != null) {
        output.add(word);
      }
    }
    return output;
  }

  private void buildTrie(Trie output, String acc, HashSet<String> path, int i, int j, char[][]board) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
      output.insert(acc);
      return;
    }

    String key = Integer.toString(i) + "_" + Integer.toString(j);
    if (path.contains(key)) {
      return;
    } else {
      path.add(key);
    }
    buildTrie(output, acc + board[i][j], path, i+1, j, board);
    buildTrie(output, acc + board[i][j], path, i, j+1, board);
    buildTrie(output, acc + board[i][j], path, i-1, j, board);
    buildTrie(output, acc + board[i][j], path, i, j-1, board);

    path.remove(key);
  }

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

    public TrieNode searchPrefix(String word) {
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

  public class TrieNode {

    private TrieNode[] links;

    private boolean isEnd;

    private final int R = 26;

    public TrieNode() {
      links = new TrieNode[26];
    }

    private int index(char ch) {
      int output = ch - 'a';
      return output;
    }

    public boolean containsKey(char ch) {
      return links[index(ch)] != null;
    }

    public TrieNode get(char ch) {
      return links[index(ch)];
    }

    public void put(char ch, TrieNode node) {
      links[index(ch)] = node;
    }

    public void setEnd() {
      isEnd =  true;
    }

    public boolean isEnd() {
      return isEnd;
    }
  }
}
