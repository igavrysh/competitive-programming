package com.company;

import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionHeap {
  Queue<Integer> heap = new PriorityQueue<>((Integer o1, Integer o2) -> { return o2 - o1; });

  private void addToPQ(int i, int k) {
    heap.add(i);
    if (heap.size() > k) {
      heap.remove();
    }
  }

  public int kthFactor(int n, int k) {
    for (int i = 1; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        addToPQ(i, k);
        if (i != n/i) {
          addToPQ(n/i, k);
        }
      }
    }
    return heap.size() == k ? heap.peek() : -1;
  }
}
