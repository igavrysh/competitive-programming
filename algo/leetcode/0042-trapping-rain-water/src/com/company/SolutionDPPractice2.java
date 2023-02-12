package com.company;

public class SolutionDPPractice2 {
    public int trap(int[] height) {
        int N = height.length;
        int[] lMax = new int[N];
        int[] rMax = new int[N];
        for (int i = 0; i < N; i++) {
            lMax[i] = i == 0 ? height[0] : Math.max(height[i], lMax[i-1]);
            rMax[N-1-i] = i == 0 ? height[N-1] : Math.max(height[N-1-i], rMax[N-1-i+1]);
        }

        int output = 0;

        for (int i = 0; i < N; i++) {
            output += Math.min(lMax[i], rMax[i]) - height[i];
        }
        
        return output;
    }
}
