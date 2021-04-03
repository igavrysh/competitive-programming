package com.company;

import java.util.Arrays;

public class SolutionMemoryOptimized2 {
  public int minSetSize(int[] arr) {
    Arrays.sort(arr);
    int size = arr.length;
    int mSize = arr[size-1]+1;
    int[] map = new int[mSize];
    for (int i = 0; i < size; i++) {
      map[arr[i]]++;
    }
    Arrays.sort(map);
    int zeroIdx = 0;
    for (int i = map.length-2; i>= 0; i--) {
      if (map[i] == 0) {
        zeroIdx = i;
        break;
      }
      map[i] += map[i+1];
    }
    int r = mSize-1;
    int l = zeroIdx+1;
    int target = size/2;
    while (l < r) {
      int mid = l + (r-l)/2;
      if (map[mid] >= target && (mid+1 >= mSize || map[mid+1] < target)) {
        return mSize-mid;
      }
      if (map[mid] < target) {
        r = mid-1;
      }
      if (map[mid] > target) {
        l = mid+1;
      }
    }
    return mSize-l;
  }
}
