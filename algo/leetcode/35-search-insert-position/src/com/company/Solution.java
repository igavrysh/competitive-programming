package com.company;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int m = 0;
        boolean found = false;
        while (l <= r) {
            m = (r+l)/2;
            if (nums[m] > target) {
                r = m-1;
            } else if (nums[m] < target) {
                l = m+1;
            } else if (nums[m] == target) {
                return m;
            }
        }
        return l;
    }
}
