package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

  public int longestStrChain(String[] words) {
    Arrays.sort(words, (String w1, String w2) -> { return w2.length() - w1.length(); });
    HashMap<String, Integer> index = new HashMap<>();
    for(int i = 0; i < words.length; i++) {
      index.put(words[i], i);
    }
    int[] DP = new int[words.length];
    for (int i = 0; i < DP.length; i++) {
      DP[i] = 1;
    }

    for (int i = 0; i < words.length; i++) {
      helper(words[i], i, index, words, DP);
    }

    int max = 1;
    for (int i = 0; i< DP.length; i++) {
      if (DP[i] > max) {
        max = DP[i];
      }
    }
    return max;
  }

  private void helper(String word, int indexOfWord, HashMap<String, Integer> index, String[] words, int[] DP) {
    if (indexOfWord >= DP.length) {
      return;
    }
    int max = DP[indexOfWord];
    for (int i = 0; i < word.length(); i++) {
      String wordToFind = removeAtIndex(word, i);
      Integer indexOfWordToFind = index.get(wordToFind);
      if (indexOfWordToFind != null) {
        helper(wordToFind, indexOfWordToFind, index, words, DP);
        int newVal = DP[indexOfWordToFind] + 1;
        if (max < newVal) {
          max = newVal;
        }
      }
    }
    DP[indexOfWord] = max;
  }

  private String removeAtIndex(String word, int idx) {
    return word.substring(0, idx) + word.substring(idx+1, word.length());
  }

  private String insertAtIndex(String word, int idx, char c) {
    return word.substring(0, idx) + c +  word.substring(idx+1);

  }
}
