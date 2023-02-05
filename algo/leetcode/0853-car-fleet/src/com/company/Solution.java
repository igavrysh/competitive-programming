package com.company;

import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] d = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            d[i] = new double[]{(double)position[i], ((double)target - position[i])/speed[i]};
        }
        Arrays.sort(d, (double[] a, double[] b) -> { return a[0] < b[0] ? -1 : 1; });
        int output = 0;
        double currentTime = 0;
        for (int i = d.length-1; i >= 0; i--) {
            if (d[i][1] > currentTime) {
                output++;
                currentTime = d[i][1];
            } else {}
        }
        return output;
    }
}