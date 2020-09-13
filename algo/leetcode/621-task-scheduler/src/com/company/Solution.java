package com.company;

import java.util.*;

public class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] FQ = new int[26];
    for (int i = 0; i < FQ.length; i++) {
      FQ[i] = 0;
    }

    Set<Character> uT = new HashSet<>();

    for (char c : tasks) {
      uT.add(c);
      FQ[c - 'A'] += 1;
    }

    Queue<Character> PQ = new PriorityQueue<>(
        uT.size(),
        (c1, c2) -> FQ[c2 - 'A'] - FQ[c1 - 'A']);
    PQ.addAll(uT);

    int cycles = 0;

    while (!PQ.isEmpty()) {
      List<Character> P = new ArrayList<>();
      for (int i = 0; i < n + 1; i++) {
        if (!PQ.isEmpty()) {
          P.add(PQ.remove());
        }
      }

      for (Character process : P) {
        FQ[process - 'A'] -= 1;
        if (FQ[process - 'A'] > 0) {
          PQ.add(process);
        }
      }

      if (!PQ.isEmpty()) {
        cycles += Math.max(n + 1, P.size());
      } else {
        cycles += P.size();
      }
    }

    return cycles;
  }

}
