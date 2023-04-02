package com.company;

import java.util.PriorityQueue;

class SolutionPQ {
    private double distSq(int[] p) {
        return Math.pow(p[0], 2) + Math.pow(p[1], 2);
    }

    public int[][] kClosest(int[][] points, int k) {
        // max heap
        PriorityQueue<int[]> PQ = new PriorityQueue<>((p1, p2) -> {
            double d1 = distSq(p1), d2 = distSq(p2);
            return d1==d2 ? 0 : (d2 < d1 ? -1 : 1);
        });

        for (int i = 0; i < points.length; i++) {
            PQ.add(points[i]);
            if (PQ.size() == k+1) {
                PQ.poll();
            }
        }

        int[][] output = new int[PQ.size()][2];
        for (int i = 0; i < output.length; i++) {
            output[i] = PQ.poll();
        }
        return output;
    }
}
