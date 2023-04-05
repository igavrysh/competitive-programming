package com.company;

import java.util.PriorityQueue;

public class MedianFinderPractice2 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a );
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> a - b);

    public MedianFinderPractice2() {
    }
    
    public void addNum(int num) {
        if (minHeap.size() > 0 && num < minHeap.peek()) {
            minHeap.add(num);
        } else if (maxHeap.size() > 0 && num > maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            if (minHeap.size() >= maxHeap.size()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
        
        if (Math.abs(minHeap.size() - maxHeap.size()) == 2) {
            if (minHeap.size() < maxHeap.size()) {
                minHeap.offer(maxHeap.poll());
            } else {
                maxHeap.offer(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek();
        } else if (minHeap.size() > 0 && maxHeap.size() > 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            throw new RuntimeException("no elements");
        }
    }
}
