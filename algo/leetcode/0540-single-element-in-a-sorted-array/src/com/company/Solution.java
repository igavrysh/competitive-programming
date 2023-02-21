package com.company;

class Solution {

    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while (r-l>1) {
            int m = l + (r-l)/2;
            if (m%2 == 0) {
                if (nums[m]==nums[m+1]) {
                    l=m+2;
                } else if (nums[m-1]==nums[m]) {
                    r=m-1;
                } else {
                    return nums[m];
                }
            } else {
                if (nums[m-1]==nums[m]) {
                    l=m+1;
                } else if (nums[m]==nums[m+1]) {
                    r=m-1;
                } else {
                    return nums[m];
                }
            }
        }
        if (l==r) return nums[l];
        if (l==0) return nums[l];
        if (r==nums.length-1) return nums[r];
        if (nums[l-1]==nums[l]) return nums[r];;
        if (nums[r]==nums[r+1]) return nums[l];
        return -1;
    }
}