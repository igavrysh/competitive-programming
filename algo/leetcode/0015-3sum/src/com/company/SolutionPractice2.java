package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionPractice2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }
            int t = -nums[i];
            int l = i+1;
            int r = nums.length-1;

            while (l < r) {
                if (nums[l]+nums[r]==t) {
                    output.add(Arrays.asList(nums[i], nums[l], nums[r]));
                }

                while (l+1<nums.length-1 && nums[l]==nums[l+1]) {
                    l++;
                }

                while (r-1>=0 && nums[r]==nums[r-1]) {
                    r--;
                }
                
                if (nums[l]+nums[r]<=t) {
                    l++;
                } else if (nums[l]+nums[r]>t) {
                    r--;
                }
            }
        }
        return output;
    }
}
