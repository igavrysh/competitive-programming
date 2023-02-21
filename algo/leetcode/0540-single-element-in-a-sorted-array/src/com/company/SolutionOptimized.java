package com.company;

public class SolutionOptimized {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length-1;
        while (r>l) {
            int m = l + (r-l)/2;
            if (m%2 == 0) {
                if (nums[m]==nums[m+1]) {
                    l=m+1;
                } else {
                    r=m;
                }
            } else {
                if (nums[m-1]==nums[m]) {
                    l=m+1;
                } else {
                    r=m;
                }
            }
        }
        return nums[l];
    }
}
