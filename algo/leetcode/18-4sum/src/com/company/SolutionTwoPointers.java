package com.company;

import java.util.*;

public class SolutionTwoPointers {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, 0, 4, target);
  }

  private List<List<Integer>> kSum(int[] nums, int s, int k, int target) {
    if (s >= nums.length
        || nums.length == 0
        || target < nums[s] * k
        || target > nums[nums.length - 1] * k
    ) {
      return new ArrayList<>();
    }

    if (k == 2) {
      List<List<Integer>> res = twoSum(nums, s, target);
      return res;
    }
    List<List<Integer>> localRes = new ArrayList<>();
    for (int i = s; i < nums.length - (k - 1); i++) {
      List<Integer> lastAdded = localRes.size() > 0 ? localRes.get(localRes.size() - 1) : null;
      if (i == s || nums[i] != nums[i - 1]) {
        List<List<Integer>> currentList = kSum(nums, i + 1, k - 1, target - nums[i]);
        for (int z = 0; z < currentList.size(); z++) {
          List<Integer> list = currentList.get(z);
          list.add(0, (Integer) nums[i]);
          localRes.add(list);
        }
      }
    }
    return localRes;
  }

  public List<List<Integer>> twoSum(int[] nums, int s, int target) {
    List<List<Integer>> res = new ArrayList<>();
    int start = s;
    int end = nums.length-1;
    while (start < end) {
      if (nums[start] + nums[end] == target) {
        List<Integer> ls = new ArrayList<>();
        ls.add(nums[start]);
        ls.add(nums[end]);
        res.add(ls);
      }

      if(target >= (nums[start] + nums[end])) {
        while (start+1 < nums.length && nums[start] == nums[start+1]) {
          start++;
        }
        start++;
      } else if (target < (nums[start] + nums[end]))   {
        while (end-1 >= 0 && nums[end] == nums[end-1]) {
          end--;
        }
        end--;
      }
    }
    return res;
  }
}
