package com.company;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] freq = new int[26];
    for (int i = 0; i < freq.length; i++) {
      freq[i] = 0;
    }

    Set<Character> uT = new HashSet<>();

    for (char c : tasks) {
      uT.add(c);
      freq[c - 'A'] += 1;
    }

    Queue<Character> pQ = new PriorityQueue<>(
        uT.size(),
        (c1, c2) -> freq[c1 - 'A'] - freq[c2 - 'A']);
    pQ.addAll(uT);




    return -1;
  }

}
