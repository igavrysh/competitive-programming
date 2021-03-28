package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public List<Integer> sequentialDigits(int low, int high) {
    Queue<Integer> queue = new LinkedList<>();
    List<Integer> output = new ArrayList<>();

    for (int i=1; i<=9; i++) {
      queue.offer(i);
    }

    while (queue.size() != 0) {
      Integer s = queue.poll();
      if (s >= low && s <= high) {
        output.add(s);
      }
      if (s%10 < 9 && s*10+(s%10+1) <= high) {
        queue.offer(s*10+(s%10+1));
      }
    }
    return output;
  }
}
