package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
  class Pair {
    char ch;
    int freq;

    public Pair(char ch, int freq) {
      this.ch = ch;
      this.freq = freq;
    }
  }

  public String reorganizeString(String S) {
    Map<Character, Integer> dictionary = new HashMap<>();
    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);
      if (dictionary.containsKey(ch)) {
        dictionary.put(ch, dictionary.get(ch) + 1);
      } else {
        dictionary.put(ch, 1);
      }
    }

    Pair[] pairs = new Pair[dictionary.size()];
    int index = 0;
    for (char ch : dictionary.keySet()) {
      pairs[index++] = new Pair(ch, dictionary.get(ch));
    }
    Arrays.sort(pairs, (p1, p2) -> p2.freq - p1.freq);

    String output = "";
    boolean valueChanged = true;

    while (valueChanged) {
      int counter = 0;
      valueChanged = false;

      for (int i = 0; i < pairs.length; i++) {
        char ch = pairs[i].ch;
        if (output.length() > 0 && output.charAt(output.length() - 1) == ch) {
          continue;
        }

        int freq = pairs[i].freq;
        if (freq > 0) {

          valueChanged = true;
          output += ch;
          pairs[i].freq = freq - 1;
          Arrays.sort(pairs, (p1, p2) -> p2.freq - p1.freq);
          i = pairs.length + 1;
        }
      }
    }

    for (int i = 0; i < pairs.length; i++) {
      if (pairs[i].freq > 0) {
        return "";
      }
    }

    return output;
  }
}