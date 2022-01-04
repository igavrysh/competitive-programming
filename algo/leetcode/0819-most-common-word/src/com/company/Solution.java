package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
  public String mostCommonWord(String paragraph, String[] banned) {
    Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
    Map<String, Integer> dictionary = new HashMap<>();

    Pattern pat = Pattern.compile("([a-zA-Z]+)");
    Matcher matcher = pat.matcher(paragraph);

    String maxWord = null;
    Integer maxFq = 0;

    while (matcher.find()) {
      String word = matcher.group().toLowerCase();

      if (!bannedWords.contains(word)) {
        Integer currentFq = dictionary.get(word);
        Integer nextFq = currentFq == null ? 1 : currentFq + 1;
        dictionary.put(word, nextFq);
        if (nextFq > maxFq) {
          maxFq = nextFq;
          maxWord = word;
        }
      }
    }

    return maxWord;
  }
}