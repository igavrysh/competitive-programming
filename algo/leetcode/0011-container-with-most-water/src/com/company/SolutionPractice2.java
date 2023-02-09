package com.company;

public class SolutionPractice2 {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int output = 0;
        while (l < r) {
            int area = (r-l) * Math.min(height[l], height[r]);
            if (output < area) {
                output = area;
            }

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return output;
    }
}