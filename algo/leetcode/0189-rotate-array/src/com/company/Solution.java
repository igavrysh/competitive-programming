package com.company;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public void rotate(int[] nums, int k) {
    k = k%nums.length;
    Queue<Integer> Q = new LinkedList<>();
    for (int i = 0; i < k; i++) {
      Q.offer(nums[i]);
    }
    for (int i = k; i < nums.length; i++) {
      Q.offer(nums[i]);
      nums[i] = Q.poll();
    }
    int i = 0;
    while (!Q.isEmpty()) {
      nums[i] = Q.poll();
      i++;
    }
  }
}