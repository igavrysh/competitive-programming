package com.company;

public class SolutionOptimized2 {
  public int lengthOfLastWord(String s) {
    boolean wordStarted = false;
    int startWord = -1;
    int endWord = -1;
    int i = s.length()-1;
    while (i >= 0) {
      if (!wordStarted) {
        if (s.charAt(i) == ' ') {
          i--;
        } else {
          wordStarted = true;
          endWord = i;
        }
      } else {
        if (s.charAt(i) == ' ') {
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
