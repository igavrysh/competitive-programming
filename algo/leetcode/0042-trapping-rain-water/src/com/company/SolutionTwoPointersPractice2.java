package com.company;

public class SolutionTwoPointersPractice2 {
    public int trap(int[] height) {
        int output = 0;
        int l = 0, r = height.length-1;
        int lMax = height[0], rMax = height[height.length-1];
        while (l<r) {
            if (height[l] < height[r]) {
                if (height[l] < lMax) {
                    output += lMax-height[l];
                } else {
                    lMax = height[l];
                }
                l++;
            } else {
                if (height[r] < rMax) {
                    output += rMax-height[r];
                } else {
                    rMax = height[r];
                }
                r--;
            }
        }
        return output;
    }
}
