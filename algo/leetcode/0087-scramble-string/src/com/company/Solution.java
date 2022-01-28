package com.company;

import java.util.HashMap;

public class Solution {

  public boolean isScramble(String s1, String s2) {
    HashMap<String, Boolean> dict = new HashMap<>();
    boolean result = bt(s1, s2, dict);
    return result;
  }

  public boolean bt(String s1, String s2, HashMap<String, Boolean> dict) {
    String key = "";
    if (s1.compareTo(s2) < 0) {
      key = new StringBuilder(s1).append(s2).toString();
    } else {
      key  = new StringBuilder(s2).append(s1).toString();
    }
    if (dict.containsKey(key)) {
      return dict.get(key);
    }
  
    if (s1.equals(s2)) {
      dict.put(key, true);
      return true;
    } else {
      if (s1.length() == 1) {
        dict.put(key, false);
        return false;
      }
    }
    if (s1.length() != s2.length()) {
      dict.put(key, false);
      return false;
    }
    int[] fq = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      fq[s1.charAt(i)-'a']++;
      fq[s2.charAt(i)-'a']--;
    }
    for (int i = 0; i < fq.length; i++) {
      if (fq[i] != 0) {
        dict.put(key, false);
        return false;
      }
    }
    for (int i = 1; i < s1.length(); i++) {
      if (bt(s1.substring(0,i), s2.substring(0,i), dict)
        && bt(s1.substring(i), s2.substring(i), dict)
      ) {
        dict.put(key, true);
        return true;
      }
      if (bt(s1.substring(0,i), s2.substring(s2.length()-i), dict)
        && bt(s1.substring(i), s2.substring(0, s2.length()-i), dict)
      ) {
        dict.put(key, true);
        return true;
      }
    }
    dict.put(key, false);
    return false;
  }
}
