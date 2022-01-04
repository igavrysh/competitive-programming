package com.company;

import java.util.*;

class Solution {
  private List<Boolean> DFS(List<List<Integer>> G, List<Integer> sp) {
    List<Boolean> marked = new ArrayList<>();
    for (int i = 0; i < G.size(); i++) {
      marked.add(false);
    }

    for (Integer i = 0; i < sp.size(); i++) {
      DFSInternal(G, sp.get(i), marked);
    }
    return marked;
  }

  private void DFSInternal(List<List<Integer>> G, Integer v, List<Boolean> marked) {
    marked.set(v, true);
    List<Integer> adj = G.get(v);
    for (int i = 0; i < adj.size(); i++) {
      if (!marked.get(adj.get(i))) {
        DFSInternal(G, adj.get(i), marked);
      }
    }
  }

  public boolean isMatch(String s, String p) {
    char[] regexp = p.toCharArray();
    List<List<Integer>> G = new ArrayList<>();
    for (int i = 0; i < p.length() + 1; i++) {
      G.add(new ArrayList<>());
    }

    for (int i = 0; i < p.length(); i++) {
      if (i < regexp.length - 1 && regexp[i + 1] == '*') {
        G.get(i).add(i + 1);
        G.get(i + 1).add(i);
      }

      if (regexp[i] == '*') {
        G.get(i).add(i + 1);
      }
    }

    char[] input = s.toCharArray();

    List<Integer> pc = new ArrayList<>();
    List<Integer> initial = new ArrayList<>();
    initial.add(0);
    List<Boolean> marked = DFS(G, initial);
    for (int j = 0; j < marked.size(); j++) {
      if (marked.get(j)) {
        pc.add(j);
      }
    }

    for (int i = 0; i < input.length; i++) {
      List<Integer> matched = new ArrayList<>();

      for (Integer v : pc) {
        if (v < regexp.length
            && (regexp[v] == input[i] || regexp[v] == '.')
        ) {
          matched.add(v + 1);
        }
      }
      pc = new ArrayList<>();
      marked = DFS(G, matched);
      for (int j = 0; j < marked.size(); j++) {
        if (marked.get(j)) {
          pc.add(j);
        }
      }
    }
    for (int i : pc) {
      if (i == p.length()) {
        return true;
      }
    }
    return false;
  }
}