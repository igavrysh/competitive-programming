package com.company;

public class SolutionPractice2 {
    public int search(int[] nums, int target) {
        int l = 0; 
        int r = nums.length-1;
        while (l < r) {
            int m = l+(r-l)/2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[l]<=nums[m] && target>=nums[l] && target<nums[m])  {
                r = m-1;
                continue;
            }
            if (nums[m]<nums[r] && target>nums[m] && target<=nums[r]) {
                l = m+1;
                continue;
            }
            if (nums[l]<=nums[m]) {
                l = m+1;
                continue;
            }
            if (nums[m]<nums[r]) {
                r = m-1;
                continue;
            }
            return -1;
        }
        if (nums[l] == target) { return l; }
        return -1;
    }
}
