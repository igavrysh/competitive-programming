package com.company;

class SolutionPrefixSuffix {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = (i == 0 ? 1 : prefix[i-1]) * nums[i];
            suffix[nums.length-1-i] = (i == 0 ? 1 : suffix[nums.length-1-i+1]) * nums[nums.length-1-i];
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = (i == 0 ? 1 : prefix[i-1])  * (i == nums.length-1 ? 1 : suffix[i+1]);
        }
        return output;
    }
}
