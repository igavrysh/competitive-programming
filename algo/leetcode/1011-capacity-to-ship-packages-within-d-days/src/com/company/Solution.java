package com.company;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lCap = Integer.MAX_VALUE;
        int rCap = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > rCap) { rCap = weights[i]; }
            if (weights[i] < lCap) { lCap = weights[i]; }
        }
        rCap *= weights.length;
        while (rCap-lCap>1) {
            int m = lCap + (rCap-lCap)/2;
            int d = 0;
            int curr = 0;
            for (int i = 0; i < weights.length; i++) {
                if (weights[i] > m) {
                    d = Integer.MAX_VALUE;
                    i=weights.length;
                } else if (curr+weights[i] > m) {
                    d++;
                    curr=weights[i];
                } else {
                    curr+=weights[i];
                }
            }
            if (curr > 0 && d != Integer.MAX_VALUE) {
                d++;
            }
            if (d <= days) {
                rCap = m;
            } else {
                lCap = m;
            }
        }
        return rCap;
    }
}