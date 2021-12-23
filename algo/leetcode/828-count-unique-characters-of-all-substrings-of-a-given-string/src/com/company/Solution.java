package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  class El {
    Integer[] d = new Integer[26];
    int unique = 0;
  }

  public int uniqueLetterString(String s) {
    int[][] DP = new int[s.length()][s.length()];
    Queue<El> Q = new LinkedList<>();

    int output = 0;

    for (int i = 0; i < s.length(); i++) {
      DP[i][i] = 0;
      El el = new El();
      el.d[s.charAt(i)-'A'] = 1;
      el.unique = 1;
      Q.offer(el);
      output += 1;
    }

    for (int k = 1; k < s.length(); k++) {
      for (int t = k; t < s.length(); t++) {
        El el = Q.poll();
        char c = s.charAt(t);
        if (el.d[c-'A'] == null) {
          el.d[c-'A'] = 1;
          el.unique++;
          output += el.unique;
        } else {
          el.d[c-'A'] = el.d[c-'A']+1;
          if (el.d[c-'A'] == 2) {
            el.unique -= 1;
          }
          output += el.unique;
        }
        Q.add(el);
      }

      Q.poll();
    }
    return output;
  }

}
