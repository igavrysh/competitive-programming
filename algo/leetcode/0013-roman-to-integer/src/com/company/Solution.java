package com.company;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  private Map<Character, Integer> dictionary;

  Solution() {
    dictionary = new HashMap<>();
    dictionary.put('I', 1);
    dictionary.put('V', 5);
    dictionary.put('X', 10);
    dictionary.put('L', 50);
    dictionary.put('C', 100);
    dictionary.put('D', 500);
    dictionary.put('M', 1000);
  }

  public int romanToInt(String s) {
    Character prevCharacter = null;
    int result = 0;
    for (char c : s.toCharArray()) {
      if (prevCharacter != null) {
        if (dictionary.get(prevCharacter) < dictionary.get(c)) {
          result += -2 * dictionary.get(prevCharacter);
        }
      }
      result += dictionary.get(c);
      prevCharacter = c;
    }
    return result;
  }
}
