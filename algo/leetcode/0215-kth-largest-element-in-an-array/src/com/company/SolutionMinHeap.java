package com.company;

import java.util.PriorityQueue;

public class SolutionMinHeap {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        for (int n : nums) {
            q.add(n);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }
}
