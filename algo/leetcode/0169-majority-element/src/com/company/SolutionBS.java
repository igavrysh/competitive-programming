package com.company;

public class SolutionBS {
    private int[] nums;

    public int majorityElement(int[] nums) {
        this.nums = nums;
        return BS(0, nums.length-1);
    }
    
    private int BS(int l, int r) {
        if (l==r) { return nums[l]; }
        int m = l + (r-l)/2; 
        int left = BS(l, m);
        int right = BS(m+1, r);
        if (left == right) {
            return left;
        }
        int leftFq = 0;
        int rightFq = 0;
        for (int i = l; i <= m; i++) {
            if (nums[i]==left) leftFq++;
        } 
        for (int i = m+1; i <= r; i++) {
            if (nums[i]==right) rightFq++;
        }
        return leftFq > rightFq ? left : right;
    }
}
