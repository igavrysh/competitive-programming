package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, 0, 4, target);
  }

  private List<List<Integer>> kSum(int[] nums, int s, int k, int target) {
    if (k == 2) {
      return twoSum(nums, s, target);
    }
    List<List<Integer>> localRes = new ArrayList<>();
    for (int i = s; i < nums.length-(k-1); i++) {
      List<Integer> lastAdded = localRes.size() > 0 ? localRes.get(localRes.size()-1) : null;
      if (i == s || nums[i] != nums[i-1]) {
        List<List<Integer>> currentList = kSum(nums, i+1, k-1, target-nums[i]);
        for (int z = 0; z < currentList.size(); z++) {
          List<Integer> list = currentList.get(z);
          list.add(0, (Integer)nums[i]);
          localRes.add(list);
        }
      }
    }
    return localRes;
  }

  public List<List<Integer>> twoSum(int[] nums, int s, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, Integer> M = new HashMap<>();
    for (int i = s; i < nums.length; i++) {
      if (M.containsKey(nums[i])) {
        if (M.get(nums[i]) != Integer.MAX_VALUE) {
          List<Integer> list = new ArrayList<>();
          list.add(M.get(nums[i]));
          list.add(nums[i]);
          res.add(list);
          M.put(nums[i], Integer.MAX_VALUE);
        }
      } else {
        M.put(target - nums[i], nums[i]);
      }
    }
    return res;
  }
}
