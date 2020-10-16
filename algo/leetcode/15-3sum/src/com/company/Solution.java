package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    HashMap<Integer, Integer> M = new HashMap<>();
    List<List<Integer>> output = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      M.put(nums[i], i);
    }

    Set<String> triplets = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      for (int j = i+1; j < nums.length; j++) {
        Integer key = -(nums[i] + nums[j]);
        Integer idx = M.get(key);
        if(idx != null && idx != i && idx != j) {
          Integer[] triplet = {nums[i], nums[j], nums[idx]};
          Arrays.sort(triplet);
          String tripletKey = triplet[0].toString()
              + "_" + triplet[1].toString()
              + "_" + triplet[2].toString();
          if (!triplets.contains(tripletKey)) {
            output.add(Arrays.asList(nums[i], nums[j], nums[idx]));
            triplets.add(tripletKey);
          }

        }
      }
    }
    return output;
  }
}
