package com.company;

public class Solution {

  public int lengthOfLastWord(String s) {
    char[] C = s.toCharArray();
    boolean wordStarted = false;
    int startWord = -1;
    int endWord = -1;
    int i = C.length-1;
    while (i >= 0) {
      if (!wordStarted) {
        if (C[i] == ' ') {
          i--;
        } else {
          wordStarted = true;
          endWord = i;
        }
      } else {
        if (C[i] == ' ') {
          startWord = i+1;
          break;
        }
        i--;
      }
    }
    if (startWord == -1 && endWord == -1) {
      return 0;
    }
    if (startWord != -1 && endWord != -1) {
      return endWord - startWord + 1;
    }
    if (startWord == -1 && endWord != -1) {
      return endWord + 1;
    }
    return 0;
  }
}
