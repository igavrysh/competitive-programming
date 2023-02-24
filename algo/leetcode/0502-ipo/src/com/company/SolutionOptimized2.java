package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionOptimized2 {
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
            if (PQ.size() == 0) {
                break;
            }
            Integer[] pair = PQ.poll();
            w += pair[0];
            cycle++;
        }
        return w;
    }
}
