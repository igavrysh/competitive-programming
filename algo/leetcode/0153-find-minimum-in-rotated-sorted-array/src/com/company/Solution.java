package com.company;

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            if (r-l == 1) {
                return Math.min(nums[l], nums[r]);
            }
            int m = l + (r-l)/2;
            if (nums[l] <= nums[m] && nums[m] <= nums[r]) {
                return nums[l];
            }

            if (nums[l] < nums[m] && nums[m] > nums[r]) {
                l = m+1;
                continue;
            }

            if (nums[l] > nums[m] && nums[m] < nums[r]) {
                r = m;
                l = l+1;
                continue;
            }
        }
        return nums[l];    
    }
}