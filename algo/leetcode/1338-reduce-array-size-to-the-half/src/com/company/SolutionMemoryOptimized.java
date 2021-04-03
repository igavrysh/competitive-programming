package com.company;

import java.util.Arrays;

public class SolutionMemoryOptimized {
  public int minSetSize(int[] arr) {
    Arrays.sort(arr);
    int size = arr.length;
    int mSize = arr[size-1]+1;
    int[] map = new int[mSize];
    for (int i = 0; i < size; i++) {
      map[arr[i]]++;
    }
    Arrays.sort(map);
    int i = mSize-1;
    int res = 0;
    int acc = 0;
    while (map[i] != 0) {
      acc += map[i];
      res++;
      if (acc >= size / 2) {
        return res;
      }
      i--;
    }
    return res;
  }
}
