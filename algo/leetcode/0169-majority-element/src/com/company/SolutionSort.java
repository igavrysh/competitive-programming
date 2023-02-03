package com.company;

import java.util.Arrays;

public class SolutionSort {
    // Time: O(NlogN)
    // Space: O(1), with input array modifications
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
