package com.company;

public class TrieNode {

  private TrieNode[] links;

  private boolean isEnd;

  private final int R = 26;

  public TrieNode() {
    links = new TrieNode[26];
  }

  private int index(char ch) {
    return ch - 'a';
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
