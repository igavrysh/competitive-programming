package com.company;

import java.util.PriorityQueue;

class Solution {
    public int minimumDeviation(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int minEl = nums[0] * (nums[0]%2==1 ? 2 : 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] * (nums[i]%2 == 1 ? 2 : 1);
            pq.offer(num);
            minEl = Math.min(minEl, num);
        }

        int output = pq.peek()-minEl;
        while (pq.peek() % 2 != 1) {
            int t = pq.poll();
            output = Math.min(output, t-minEl);
            int newT = t/2;
            minEl = Math.min(minEl, newT);
            pq.offer(newT);
        }
        return Math.min(output, pq.poll()-minEl);
    }
}