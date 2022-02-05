package com.company;
import java.util.HashMap;

public class Solution {
  public int findMaxLength(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int res = 0;
    int acc = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        acc += 1;
      } else {
        acc -= 1;
      }

      Integer prevOcc = map.get(acc);
      if (prevOcc == null) {
        map.put(acc, i);
      }
      
      if (prevOcc != null) {
        int distance = i-prevOcc;
        if (res < distance) {
          res = distance;
        }
      }
    }
    return res;
  }
}
