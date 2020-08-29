package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> output = new ArrayList<>();
    partitionInternal(s, 0, new ArrayList<>(), output);
    return output;
  }

  private void partitionInternal(
      String s,
      int startIndex,
      List<String> acc,
      List<List<String>> output
  ) {
    if (startIndex >= s.length()) {
      output.add(new ArrayList<>(acc));
    }

    for (int i = startIndex; i < s.length(); i++) {
      if (isPalindrome(s, startIndex, i)) {
        acc.add(s.substring(startIndex, i+1));
        partitionInternal(s, i+1, acc, output);
        acc.remove(acc.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int startIdx, int endIdx) {
    for (int i = 0; i < (endIdx + 1 - startIdx) / 2; i++) {
      if (s.charAt(startIdx + i) != s.charAt(endIdx - i)) {
        return false;
      }
    }
    return true;
  }
}
