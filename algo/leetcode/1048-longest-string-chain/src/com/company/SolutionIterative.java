package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class SolutionIterative {

  public int longestStrChain(String[] words) {
    Arrays.sort(words, (String w1, String w2) -> { return w2.length() - w1.length(); });
    int[] DP = new int[words.length];
    HashMap<String, Integer> index = new HashMap<>();
    int w = 0;
    Stack<StringBuilder> S = new Stack<>();
    for (int i = 0; i < words.length; i++) {
      DP[i] = -1;
      index.put(words[i], i);
    }

    int globalMax = 1;

    while (w < words.length || !S.isEmpty()) {
      if (S.isEmpty()) {
        StringBuilder sb = new StringBuilder(words[w]);
        S.push(sb);
        w++;
      } else {
        StringBuilder sb = S.pop();
        List<StringBuilder> toPush = new ArrayList<>();
        int maxChain = 0;
        for (int i = 0; i < sb.length(); i++) {
          char c = sb.charAt(i);
          sb.replace(i, i+1, "");
          String str = sb.toString();
          if (index.get(str) != null) {
            Integer idx = index.get(str);
            if (DP[idx] == -1) {
              toPush.add(new StringBuilder(str));
            } else {
              if (maxChain < DP[idx]) {
                maxChain = DP[idx];
              }
            }
          }
          sb.insert(i, c);
        }
        if (toPush.size() == 0) {
          Integer idx = index.get(sb.toString());
          DP[idx] = 1 + maxChain;
          if (DP[idx] > globalMax) {
            globalMax = DP[idx];
          }
        } else {
          S.push(sb);
          for (StringBuilder childSB : toPush) {
            S.push(childSB);
          }
        }
      }
    }
    return globalMax;
  }

}
