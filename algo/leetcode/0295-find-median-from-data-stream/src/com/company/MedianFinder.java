package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

  private PriorityQueue<Integer> HMin;
  private PriorityQueue<Integer> LMax;

  public MedianFinder() {
    HMin = new PriorityQueue<>(Comparator.comparingInt((Integer o) -> o));
    LMax = new PriorityQueue<>((Integer o1, Integer o2) -> {
      return o2 - o1;
    });
  }

  public void addNum(int num) {
    Integer topHMin = HMin.peek();
    Integer topLMax = LMax.peek();
    int sizeHMin = HMin.size();
    int sizeLMax = LMax.size();

    if (sizeLMax <= sizeHMin) {
      if (topLMax == null || num <= topHMin) {
        LMax.add(num);
      } else if (num > topHMin) {
        int s = HMin.poll();
        LMax.add(s);
        HMin.add(num);
      } else {
        throw new RuntimeException("unexpected state reached");
      }
    } else if (sizeLMax > sizeHMin) {
      if (topLMax == null || num >= topLMax) {
        HMin.add(num);
      } else if (num < topLMax) {
        int s = LMax.poll();
        LMax.add(num);
        HMin.add(s);
      } else {
        throw new RuntimeException("unexpected state reached");
      }
    }
  }

  public double findMedian() {
    int sizeHMin = HMin.size();
    int sizeLMax = LMax.size();
    if (sizeHMin == sizeLMax) {
      int sum = HMin.peek() + LMax.peek();
      return sum / 2.0;
    } else if (sizeHMin < sizeLMax) {
      return LMax.peek();
    } else if (sizeHMin > sizeLMax) {
      return HMin.peek();
    }
    throw new RuntimeException("unexpected state reached " + sizeHMin + ":" + sizeLMax);
  }

}
