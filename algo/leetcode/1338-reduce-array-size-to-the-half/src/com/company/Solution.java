package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
  public int minSetSize(int[] arr) {
    Map<Integer, Integer> fq = new HashMap<>();
    for (int e : arr) {
      fq.put(e, fq.get(e) == null ? 1 : fq.get(e) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> fq.get(b) - fq.get(a));
    for (Integer e : fq.keySet()) {
      pq.add(e);
    }
    int acc = 0;
    int result = 0;
    while (pq.size() != 0 && acc < arr.length / 2) {
      Integer e = pq.poll();
      acc += fq.get(e);
      result++;
    }
    return result;
  }
}
