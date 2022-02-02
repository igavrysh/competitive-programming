package com.company;

import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    int[] fq = new int[26];
    for (char c : p.toCharArray()) {
      fq[c-'a']++;
    }
    List<Integer> res = new ArrayList<>();
    int[] actualFq = new int[26];
    int matched = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i >= p.length()) {
        char toRemove = s.charAt(i-p.length());
        actualFq[toRemove-'a']--;
        if (fq[toRemove-'a'] > 0 && actualFq[toRemove-'a'] < fq[toRemove-'a']) {
          matched--;
        }
      }
      char c = s.charAt(i);
      actualFq[c-'a']++;
      if (fq[c-'a'] > 0 && actualFq[c-'a'] <= fq[c-'a']) {
        matched++;
      }
      if (i >= p.length()-1) {
        if (matched == p.length()) {
          res.add(i-(p.length()-1));
        }
      }
    }
    return res;
  }
}