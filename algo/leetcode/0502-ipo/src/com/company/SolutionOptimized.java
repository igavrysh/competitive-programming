package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionOptimized {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] pairs = new int[capital.length][2];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new int[]{profits[i], capital[i]};
        }
        Arrays.sort(pairs, (p1, p2) -> p1[1] - p2[1]);

        PriorityQueue<Integer[]> PQ = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1]-b[1];
            } else {
                return b[0]-a[0];
            }
        });
        
        int j = 0;
        int cycle = 0;
        
        while (cycle < k) {
            while (j<pairs.length && pairs[j][1] <= w) {
                PQ.offer(new Integer[]{pairs[j][0], pairs[j][1]});
                j++;
            }
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
