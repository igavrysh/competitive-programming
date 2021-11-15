package com.company;

import java.util.HashMap;

public class SolutionHashmap {
  public int maxOperations(int[] nums, int k) {
    HashMap<Integer, Integer> H = new HashMap<>();
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      if (H.get(k-nums[i]) == null) {
        int key = nums[i];
        if (H.get(key) == null) {
          H.put(key, 1);
        } else {
          H.put(key, H.get(key)+1);
        }
      } else {
        result++;
        int key = k-nums[i];
        if (H.get(key) == 1) {
          H.remove(key);
        } else {
          H.put(key, H.get(key)-1);
        }
      }
    }
    return result;
  }
}
