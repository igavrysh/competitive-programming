package com.company;

import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<String> letterCombinations(String digits) {
    Map<Character, String> keyboard = new HashMap<Character, String>();
    keyboard.put('2', "abc");
    keyboard.put('3', "def");
    keyboard.put('4', "ghi");
    keyboard.put('5', "jkl");
    keyboard.put('6', "mno");
    keyboard.put('7', "pqrs");
    keyboard.put('8', "tuv");
    keyboard.put('9', "wxyz");

    List<String> output = new ArrayList<>();
    letterCombinationsInternal(keyboard, digits, 0, null, output);
    return output;
  }

  private void letterCombinationsInternal(
      Map<Character, String> keyboard,
      String digits,
      int index,
      String acc,
      List<String> output
  ) {
    if (index >= digits.length()) {
      if (acc != null) {
        output.add(new String(acc));
      }
      return;
    }

    String values = keyboard.get(digits.charAt(index));
    for (char c : values.toCharArray()) {
      letterCombinationsInternal(
          keyboard,
          digits,
          index + 1,
          (acc == null ? "" : acc) + String.valueOf(c),
          output);
    }
  }
}

