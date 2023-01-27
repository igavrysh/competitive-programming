package com.company;

public class SolutionPrefixSuffixInPlace {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int tmp = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            output[i] = output[i]*tmp;
            tmp *= nums[i];
        }
        return output;
    }
}
