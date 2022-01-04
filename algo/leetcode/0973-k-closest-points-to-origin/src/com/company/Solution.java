package com.company;

import java.util.Random;

public class Solution {
  private void swap(int i, int j, int [][]points) {
    int[] tmp = points[i];
    points[i] = points[j];
    points[j] = tmp;
  }

  public int[][] kClosest(int[][] points, int k) {
    quickSelect(k, 0, points.length-1, points);
    int[][] output = new int[k][2];
    for (int i = 0; i < k; i++) {
      output[i] = points[i];
    }
    return output;
  }

  private int partition(int l, int r, int pivot, int[][] points) {
    if (l == r) {
      return l;
    }

    double distPivot = dist(points[pivot]);

    // move pivot to the right
    swap(pivot, r, points);

    // move smaller points to the left
    int storeIndex = l;
    for (int i = l; i < r; i++) {
      if (dist(points[i]) < distPivot) {
        swap(storeIndex, i, points);
        storeIndex++;
      }
    }

    // put pivot to its final place
    swap(r, storeIndex, points);
    return storeIndex;
  }

  private void quickSelect(int k, int l, int r, int[][] points) {
    Random rand = new Random();

    int pivotIdx = l + rand.nextInt(r-l+1);

    int pos = partition(l, r, pivotIdx, points);

    if (pos == k-1) {
      return;
    } else if (pos > k-1) {
      r = pos-1;
      quickSelect(k, l, r, points);
    } else {
      l = pos+1;
      quickSelect(k, l, r, points);
    }
  }

  private double dist(int[] point) {
    return Math.pow(point[0], 2) + Math.pow(point[1], 2);
  }


}
