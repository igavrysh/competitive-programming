package com.company;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((Integer a, Integer b) -> b.compareTo(a));
        for (int n : nums) {
            q.add(n);
        }

        Integer output = 0;
        int i = 0;
        while (i < k) {
            output = q.poll();
            i++;
        }
        return output;
    }
}
