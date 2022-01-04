package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<List<String>> partition(String s) {
    List<List<String>> output = new ArrayList<>();
    partitionInternal(s, 0, s.length() - 1, output, new ArrayList<>());
    return output;
  }

  private void partitionInternal(
      String s,
      int start,
      int end,
      List<List<String>> output,
      List<String> currentOutput) {
    while (start <= end) {
      for (int i = 0; i <= (end - start); i++) {
        if (isPalindrome(s, start, start + i)) {
          currentOutput.add(s.substring(start, start + i + 1));
          if (i == (end - start)) {
            List<String> copy = new ArrayList<>();
            copy.addAll(currentOutput);
            output.add(copy);
          } else {
            partitionInternal(s, start + i + 1, end, output, currentOutput);
          }
          currentOutput.remove(currentOutput.size() - 1);
        }
      }
      return;
    }
  }

  private boolean isPalindrome(String s, int start, int end) {
    for (int i = 0; i <= (int) ((end - start) / 2); i++) {
      if (s.charAt(start + i) != s.charAt(end - i)) {
        return false;
      }
    }
    return true;
  }
}