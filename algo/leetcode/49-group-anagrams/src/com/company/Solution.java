package com.company;

import java.util.*;

public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] k = str.toCharArray();
      Arrays.sort(k);
      String key = String.valueOf(k);
      if (!map.containsKey(key)) {
        List<String> a = new ArrayList<>();
        a.add(str);
        map.put(key, a);
      } else {
        List<String> a = map.get(key);
        a.add(str);
      }
    }
    List<List<String>> output = new ArrayList<>();
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      output.add(entry.getValue());
    }
    return output;
  }
}
