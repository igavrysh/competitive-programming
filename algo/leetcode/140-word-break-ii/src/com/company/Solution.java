package com.company;

import java.util.*;

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
    Stack<Integer> indexes = new Stack<>();
    Stack<String> acc = new Stack<>();
    indexes.push(s.length()-1);
    acc.push("");
    while(indexes.size() != 0) {
      Integer currentIndex = indexes.pop();
      String currentAcc = acc.pop();

      if(currentIndex < 0) {
        if (currentAcc != "") {
          output.add(currentAcc);
        }
      } else {
        List<Integer> currentMap = DP.get(currentIndex);
        for (Integer i : currentMap) {
          indexes.push(currentIndex - i);
          acc.push(s.substring(currentIndex - i + 1, currentIndex + 1) + (currentAcc == "" ? "" : " " + currentAcc));
        }
      }
    }
    return output;
  }
}
