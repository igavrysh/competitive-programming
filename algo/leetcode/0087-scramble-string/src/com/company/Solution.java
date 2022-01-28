package com.company;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Solution {

  class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public boolean isScramble(String s1, String s2) {
    HashSet<String> dict = new HashSet<>();
    dict.add(s1);
    ArrayList<Pair<Integer, Integer>> ps = new ArrayList<>();
    ps.add(new Pair<>(0, s1.length() - 1));
    boolean res = bt(ps, s1, s2, dict);
    return res;
  }

  private boolean bt(ArrayList<Pair<Integer, Integer>> pairs, String str, String toFind,
      HashSet<String> dict) {
    if (str.equals(toFind)) {
      return true;
    }

    for (int j = 0; j < pairs.size(); j++) {
      Pair<Integer, Integer> p = pairs.get(j);
      if (p.value - p.key == 0) {
        continue;
      }
      int s = p.key;
      int e = p.value;
      pairs.remove(j);
      for (int i = s + 1; i <= e; i++) {
        String w1 = str.substring(s, i);
        String w2 = str.substring(i, e + 1);
        String w = str.substring(0, s) + w2 + w1 + str.substring(e+1);
        
        pairs.add(new Pair<>(s, s+(e-i)));
        pairs.add(new Pair<>(s+(e-i)+1, e));
        String key = getKey(w, pairs);
        if (!dict.contains(key)) {
          dict.add(key);
          boolean res = bt(pairs, w, toFind, dict);
          if (res) {
            return true;
          }
        }
        pairs.remove(pairs.size() - 1);
        pairs.remove(pairs.size() - 1);

        pairs.add(new Pair<>(s, i-1));
        pairs.add(new Pair<>(i, e));
        key = getKey(str, pairs);
        if (!dict.contains(key)) {
          dict.add(key);
          boolean res = bt(pairs, str, toFind, dict);
          if (res) {
            return true;
          }
        }
        pairs.remove(pairs.size() - 1);
        pairs.remove(pairs.size() - 1);
      }
      pairs.add(j, p);
    }
    return false;
  }

  private String getKey(String str, ArrayList<Pair<Integer, Integer>> pairs) {
    StringBuilder sb = new StringBuilder(str);
    for (Pair<Integer, Integer> p : pairs) {
      sb.append("_");
      sb.append(p.key);
    }
    String s = sb.toString();
    return s;
  }
}
