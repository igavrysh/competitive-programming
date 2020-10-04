package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
    int maxLength = 0;
    for (String word : wordDict) {
      if (maxLength < word.length()) {
        maxLength = word.length();
      }
    }
    Set<String> wd = new HashSet<>(wordDict);

    List<List<Integer>> DP = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      DP.add(new ArrayList<>());
    }

    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j <= i; j++) {
        String current = s.substring(j, i+1);
        if (wd.contains(current)
            && (j == 0 || DP.get(j-1).size() > 0)
        ) {
          DP.get(i).add((i - j + 1));
        }
      }
    }
    List<String> output = new ArrayList<>();
    generateString(s.length()-1, "", s, DP, output);
    return output;
  }

  private void generateString(
      int index,
      String acc,
      String s,
      List<List<Integer>> map,
      List<String> output
  ) {
    if (index < 0) {
      output.add(acc);
      return;
    }

    List<Integer> currentMap = map.get(index);
    for (Integer i : currentMap) {

      generateString(index-i, s.substring(index-i+1, index+1) + (acc == "" ? "" : " " + acc), s, map, output);
    }
  }

}
