package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SolutionRecursive {

  public int longestStrChain(String[] words) {
    Arrays.sort(words, (String w1, String w2) -> { return w2.length() - w1.length(); });
    HashMap<String, Integer> index = new HashMap<>();
    for(int i = 0; i < words.length; i++) {
      index.put(words[i], i);
    }
    int[] DP = new int[words.length];
    for (int i = 0; i < DP.length; i++) {
      DP[i] = -1;
    }
    List<Integer> res = new ArrayList<>();
    res.add(1);
    for (int i = 0; i < words.length; i++) {
      helper(words[i], i, index, words, DP, res);
    }
    return res.get(0);
  }

  private void helper(String word, int indexOfWord, HashMap<String, Integer> index, String[] words,
      int[] DP, List<Integer> result) {
    if (indexOfWord >= DP.length) {
      return;
    }
    int max = 1;
    for (int i = 0; i < word.length(); i++) {
      String wordToFind = new StringBuilder(word).deleteCharAt(i).toString();
      Integer indexOfWordToFind = index.get(wordToFind);
      if (indexOfWordToFind != null) {
        if (DP[indexOfWordToFind] == -1) {
          helper(wordToFind, indexOfWordToFind, index, words, DP, result);
        }
        int newVal = DP[indexOfWordToFind] + 1;
        if (max < newVal) {
          max = newVal;
        }
      }
    }
    DP[indexOfWord] = max;
    if (result.get(0) < DP[indexOfWord]) {
      result.set(0, DP[indexOfWord]);
    }
  }
}
