package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Set<String> wd = new HashSet<>(Arrays.asList(words));
    int maxLength = words.length > 0 ? words[0].length() : 0;
    for (String word : words) {
      maxLength = word.length() > maxLength ? word.length() : maxLength;
    }

    ArrayList[] DP = new ArrayList[maxLength];
    for (int i = 0; i < DP.length; i++) {
      DP[i] = new ArrayList();
    }

    List<String> output = new ArrayList<>();
    for (String word : words) {
      if (compositeOfWords(word, wd, maxLength, DP)) {
        output.add(word);
      }
    }
    return output;
  }

  private boolean compositeOfWords(String word, Set<String> wd, int maxLength, ArrayList[]DP) {
    if (word.length() == 0) {
      return false;
    }

    for (int i = 0; i < word.length(); i++) {
      DP[i].clear();
    }

    for (int i = 0; i < word.length(); i++) {
      for (int j = i; j >= 0 && i-j+1 <= maxLength; j--) {
        String s = word.substring(j, i+1);
        if ((j == 0 || DP[j-1].size() > 0) && wd.contains(s)) {
          DP[i].add(j);
        }
      }
    }
    return DP[word.length()-1].size() > 1;
  }

}
