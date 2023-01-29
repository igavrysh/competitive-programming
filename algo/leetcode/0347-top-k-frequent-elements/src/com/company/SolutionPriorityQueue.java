package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class SolutionPriorityQueue {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> fq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            fq.put(nums[i], fq.getOrDefault(nums[i], 0) + 1);
        }
        if (fq.size() < k) {
            return null;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
            return fq.get(x) > fq.get(y) ? 1 : fq.get(x) < fq.get(y) ? -1 : 0;
        });

        for (Map.Entry<Integer, Integer> e : fq.entrySet()) { 
            pq.add(e.getKey());
            // to keep complexity O(Nlog(k)) remove min element from pq 
            // to avoid overflow and time complexity slide into O(NlogN)
            if (pq.size() == k+1) {
                pq.poll();
            }
        }

        int[] output = new int[k];
        int i = 0;
        while (!pq.isEmpty()) { 
            output[i++] = pq.poll();
        }

        return output;
    }
}
