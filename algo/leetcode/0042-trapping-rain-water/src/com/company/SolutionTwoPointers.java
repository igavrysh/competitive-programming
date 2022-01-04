package com.company;

public class SolutionTwoPointers {
  public int trap(int[] height) {
    int l = 0;
    int r = height.length-1;
    int prevLMaxHeight = 0;
    int prevRMaxHeight = 0;
    int water = 0;
    while (l <= r) {
      if (height[l] <= height[r]) {
        if (height[l] < prevLMaxHeight) {
          water += prevLMaxHeight - height[l];
        }
        if (prevLMaxHeight < height[l]) {
          prevLMaxHeight = height[l];
        }
        l++;
      } else if (height[l] > height[r]) {
        if (height[r] < prevRMaxHeight) {
          water += prevRMaxHeight - height[r];
        }
        if (prevRMaxHeight < height[r]) {
          prevRMaxHeight = height[r];
        }
        r--;
      }
    }
    return water;
  }
}
