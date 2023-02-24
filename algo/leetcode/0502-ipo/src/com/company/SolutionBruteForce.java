package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class SolutionBruteForce {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer[]> PQ = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1]-b[1];
            } else {
                return b[0]-a[0];
            }
        });
        for (int i = 0; i < profits.length; i++) {
            PQ.offer(new Integer[]{profits[i], capital[i]});
        }

        int cycle = 0;
        
        while (cycle < k) {
            int wealth = w;
            List<Integer[]> toAdd = new ArrayList<>();
            
            boolean picked = false;
            while(PQ.size() > 0 && !picked) {
                Integer[] pair = PQ.poll();
                if (pair[1] <= wealth) {
                    wealth -= pair[1];
                    w += pair[0];
                    picked = true;
                } else {
                    toAdd.add(pair);
                }
            }

            while (toAdd.size() > 0) {
                PQ.offer(toAdd.remove(toAdd.size()-1));
            }
            cycle++;
        }

        return w;
    }
}