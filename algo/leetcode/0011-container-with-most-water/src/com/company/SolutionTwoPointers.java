package com.company;

public class SolutionTwoPointers {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = Math.min(height[l], height[r]) * (r - l);

        while (l < r) {
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
            int newArea = Math.min(height[l], height[r]) * (r - l);
            if (maxArea < newArea) {
                maxArea = newArea;
            }
        }
        return maxArea;
    }
}
