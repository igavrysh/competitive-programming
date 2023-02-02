package com.company;

public class SolutionQuickFind {
    public int majorityElement(int[] nums) {
        int k = nums.length / 2;
        quickFind(0, nums.length-1, k, nums);
        return nums[k];
    }

    private void quickFind(int s, int e, int k, int[] nums) {
        if (s > e) { return; }
        swap(s, e, nums);
        int i = s, j = s;
        while (j < e) {
            if (nums[j] <= nums[e]) {
                swap(i, j, nums);
                i++;
            }
            j++;
        }
        swap(i, e, nums);

        if (i == k) {
            return;
        }

        if (i < k) {
            quickFind(i+1, e, k- (i-s+1), nums);
        } else {
            quickFind(s, i-1, k, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        if (i==j) { return; }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
