package com.company;

import java.util.*;

import static java.util.Objects.hash;

public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<Integer, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] keyCh = str.toCharArray();
      int [] keyInt = new int[26];
      for (char c : keyCh) {
        int idx = c-'a';
        keyInt[c-'a']++;
      }
      Integer keyHashed = Arrays.hashCode(keyInt);
      if (!map.containsKey(keyHashed)) {
        List<String> a = new ArrayList<>();
        a.add(str);
        map.put(keyHashed, new ArrayList<>(Arrays.asList(str)));
      } else {
        map.get(keyHashed).add(str);
      }
    }
    List<List<String>> output = new ArrayList<>();
    for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
      output.add(entry.getValue());
    }
    return output;
  }
}
