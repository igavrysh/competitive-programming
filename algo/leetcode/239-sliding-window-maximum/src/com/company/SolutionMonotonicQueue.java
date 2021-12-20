package com.company;

import java.util.ArrayDeque;

public class SolutionMonotonicQueue {
  private ArrayDeque<Integer> dq = new ArrayDeque<>();

  private void cleanDeque(int[] nums, int i, int k) {
    if (!dq.isEmpty() && i-dq.peekFirst() >= k ) {
      dq.removeFirst();
    }

    while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
      dq.removeLast();
    }
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    for (int i = 0; i < k; i++) {
      cleanDeque(nums, i, k);
      dq.addLast(i);
    }

    int[] output = new int[nums.length - k + 1];
    output[0] = nums[dq.peekFirst()];

    for (int i = k; i < nums.length; i++) {
      cleanDeque(nums, i, k);
      dq.addLast(i);
      output[i-k+1] = nums[dq.peekFirst()];
    }
    return output;
  }

}
