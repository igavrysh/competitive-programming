package com.company;

import java.util.PriorityQueue;
import java.util.Queue;
import javafx.util.Pair;

public class Solution {
  Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>((Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) -> {
    if (p1.getValue() == p2.getValue()) {
      return p1.getKey() - p2.getKey();
    }
    return p1.getValue() - p2.getValue();
  });

  public int maxEvents(int[][] events) {
    for (int[] e : events) {
      queue.add(new Pair<>(e[0], e[1]));
    }
    int output = 0;
    int currTime = 0;
    if (queue.size() > 0) {
      Pair <Integer, Integer> p = queue.poll();
      currTime = p.getKey()+1;
      output++;
    }
    while (queue.size() > 0) {
      Pair <Integer, Integer> p = queue.poll();
      if (currTime <= p.getValue()) {
        currTime = Math.max(currTime+1, p.getKey()+1);
        output++;
      }
    }
    return output;
  }
}
