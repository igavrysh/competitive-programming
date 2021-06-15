package com.company;

import java.util.Stack;

public class Solution {
  public boolean search(int[] nums, int target) {
    int l = 0;
    int r = nums.length-1;

    Stack<int[]> stack = new Stack<>();

    while (l <= r || stack.size() != 0) {
     if (l > r) {
       int[] t = stack.pop();
       l = t[0];
       r = t[1];
     }

      int m = l + (r-l) / 2;
      if (nums[m] == target) {
        return true;
      }

      if (nums[l] == nums[r] && nums[l] == nums[m]) {
        if (m+1 <= r) {
          stack.push(new int[]{m + 1, r});
        }
        r = m-1;
        continue;
      }

      if (nums[l] <= nums[m] && nums[m] <= nums[r]) {
        if (nums[m] >= target) {
          r = m-1;
        } else {
          l = m+1;
        }
      } else if (nums[l] >= nums[m] && nums[m] >= nums[r]) {
        if (nums[m] >= target) {
          if (nums[m] == nums[r] && l <= m-1) {
            stack.push(new int[]{l, m-1});
          }
          l = m+1;
        } else {
          if (nums[l] == nums[m] && m+1 <= r) {
            stack.push(new int[]{m+1, r});
          }
          r = m-1;
        }
      } else if (nums[l] <= nums[m] && nums[m] >= nums[r]) {
        if (nums[l] <= target && nums[m] >= target) {
          r = m;
        } else {
          l = m;
        }
      } else if (nums[l] >= nums[m] && nums[m] <= nums[r]) {
        if (nums[m] <= target && nums[r] >= target) {
          l = m;
        } else {
          r = m;
        }
      }
    }
    return false;
  }
}




