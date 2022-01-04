package com.company;

public class SolutionBruteForce {
  public int maxArea(int[] height) {
    int maxArea = 0;
    for (int i = 0; i < height.length; i++) {
      for (int j = 0; j < i; j++) {
        int area = Math.min(height[i], height[j]) * (i - j);
        if (area > maxArea) {
          maxArea = area;
        }
      }
    }
    return maxArea;
  }
}
