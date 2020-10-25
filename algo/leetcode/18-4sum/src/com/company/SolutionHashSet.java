package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionHashSet {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, 0, 4, target);
  }

  private List<List<Integer>> kSum(int[] nums, int s, int k, int target) {
    if (s >= nums.length
        || nums.length == 0
        || target < nums[s] * k
        || target > nums[nums.length-1] * k
    ) {
      return new ArrayList<>();
    }

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
    Set<Integer> HS = new HashSet<>();

    for (int i = s; i < nums.length; i++) {
      if (HS.contains(target - nums[i])) {
        if (res.size() == 0 || res.get(res.size() - 1).get(1) != nums[i]) {
          List<Integer> ls = new ArrayList<>();
          ls.add(target-nums[i]);
          ls.add(nums[i]);
          res.add(ls);
        }
      }
      HS.add((Integer)nums[i]);
    }
    return res;
  }
}
