package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// edge cases: [0, 0, 0, 0], [-2, 0, 1, 1, 2]
public class SolutionPractice2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            int t = -nums[i];
            int l = i+1;
            int r = nums.length-1;

            while (l < r) {
                if (nums[l]+nums[r]==t) {
                    output.add(Arrays.asList(nums[i], nums[l], nums[r]));
                }

                if (l<nums.length && r>i && nums[l]+nums[r]<=t) {
                    while (l+1 < nums.length && nums[l] == nums[l+1] && l+1<r) {
                        l++;
                    }
                    l++;
                } else if (l<nums.length && r>i && nums[l]+nums[r]>=t) {
                    while (r-1 >= i && nums[r] == nums[r-1] && l<r-1) {
                        r--;
                    }
                    r--;
                }
            }

            while (i >= 0 && i+1 <nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return output;
    }
}
