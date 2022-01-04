package com.company;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        boolean found = false;
        int idx = -1;
        while (l <= r && !found) {
            int m = l+(r-l)/2;
            if (nums[m] < target) {
                l = m+1;
            } else if (nums[m] > target) {
                r = m-1;
            } else if (nums[m] == target) {
                idx = m;
                found = true;
            }
        }

        if (!found) {
            return new int[] {-1, -1};
        }

        int rOffset = 0;
        while (idx+rOffset+1 < nums.length && nums[idx+rOffset+1] == target) {
            rOffset++;
        }

        int lOffset = 0;
        while (idx-lOffset-1 >= 0 && nums[idx-lOffset-1] == target) {
            lOffset++;
        }
        return new int[] {idx-lOffset, idx+rOffset};
    }
}
