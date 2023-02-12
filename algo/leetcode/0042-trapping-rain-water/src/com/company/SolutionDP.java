package com.company;

public class SolutionDP {
    public int trap(int[] height) {
        int[] lDP = new int[height.length];
        int[] rDP = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            lDP[i] = Math.max(i > 0 ? lDP[i - 1] : 0, height[i]);
            rDP[height.length - 1 - i] = Math.max(i > 0 ? rDP[height.length - 1 - i + 1] : 0,
                    height[height.length - 1 - i]);
        }
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            water += Math.min(lDP[i], rDP[i]) - height[i];
        }
        return water;
    }
}
