package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class SolutionTie1 {
  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    List<String> res = new LinkedList<>();
    Arrays.sort(words, (a,b) -> a.length() - b.length());
    for (String w: words){
      if (w.length() == 0) continue;
      if (dfs(w, 0, root)) res.add(w);
      else buildTrie(w, root);
    }
    return res;
  }

  boolean dfs(String s, int idx, Node cur){
    if (idx == s.length()){
      return cur.isWord;
    }
    char c = s.charAt(idx);
    cur = cur.next[c - 'a'];
    if (cur == null) return false;
    if (cur.isWord && dfs(s, idx + 1, root)) return true;
    return dfs(s, idx + 1, cur);
  }

  class Node{
    Node[] next = new Node[26];
    boolean isWord = false;
  }
  Node root = new Node();

  void buildTrie(String s, Node cur){
    for (char c: s.toCharArray()){
      if (cur.next[c - 'a'] == null)
        cur.next[c - 'a'] = new Node();
      cur = cur.next[c - 'a'];
    }
    cur.isWord = true;
  }
}