package com.company;

public class SolutionOptimized {
    public int shipWithinDays(int[] weights, int days) {
        if (weights == null) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int totalW = 0;
        for (int weight : weights) {
            totalW += weight;
            max = Integer.max(max, weight);
        }
        int l = Math.max(max, totalW/days);
        int r = totalW;
        int output = -1;
        while(l<=r) {
            int m = (r+l)/2;
            int[] ships = new int[days];
            int start = 0;
            for (int i = 0; i < ships.length; i++) {
                for (;start<weights.length && ships[i]+weights[start]<=m;start++) {
                    ships[i]+=weights[start];
                }
            }
            if (start==weights.length) {
                output = m;
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return output;
    }
}
