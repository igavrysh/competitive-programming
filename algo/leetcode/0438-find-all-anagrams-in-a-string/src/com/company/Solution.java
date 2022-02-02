package com.company;

import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    int ns = s.length(), np = p.length();
    if (np > ns) {
      return new ArrayList<>();
    }

    int[] fqP = new int[26];
    for (char c : p.toCharArray()) {
      fqP[c-'a']++;
    }
    List<Integer> res = new ArrayList<>();
    int[] fqS = new int[26];
    int matched = 0;
    for (int i = 0; i < ns; i++) {
      if (i >= p.length()) {
        char toRemove = s.charAt(i-np);
        fqS[toRemove-'a']--;
        if (fqP[toRemove-'a'] > 0 && fqS[toRemove-'a'] < fqP[toRemove-'a']) {
          matched--;
        }
      }
      char c = s.charAt(i);
      fqS[c-'a']++;
      if (fqP[c-'a'] > 0 && fqS[c-'a'] <= fqP[c-'a']) {
        matched++;
      }
      if (i >= p.length()-1 && matched == p.length()) {
        res.add(i-(p.length()-1));
      }
    }
    return res;
  }
}